package com.phenikaa.hrm.Presentation_Layer;

import com.phenikaa.hrm.Business_Logic_Layer.ITimekeepingService;
import com.phenikaa.hrm.Business_Logic_Layer.TimekeepingService;
import com.phenikaa.hrm.Data_Access_Layer.TimekeepingRepository;
import com.phenikaa.hrm.Data_Access_Layer.UserRepository;
import com.phenikaa.hrm.dto.TimekeepingDto;
import com.phenikaa.hrm.entity.Timekeeping;
import com.phenikaa.hrm.entity.User;
import com.phenikaa.hrm.form.FormCreateTimekeeping;
import com.phenikaa.hrm.form.FormTimeKeeping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/timekeeping")
public class TimekeepingController {
    @Autowired
    ITimekeepingService timekeepingService;

    @Autowired
    TimekeepingRepository timekeepingRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<?> GetAllTimeKeeping(Pageable pageable, String search,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startTime,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endTime) {
        if(search == null){
            search="";
        }

        if(startTime == null){
            startTime = LocalDate.of(1900, 1, 1);
        }

        if(endTime == null){
            endTime = LocalDate.of(3000, 1, 1);
        }

        List<FormTimeKeeping> list = timekeepingService.getAllTimekeeping(search,startTime,endTime);
        if (pageable.getOffset() >= list.size()) {
            new ResponseEntity<>(Page.empty(), HttpStatus.OK);
        }
        int startIndex = (int)pageable.getOffset();
        int endIndex = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ?
                list.size() :
                pageable.getOffset() + pageable.getPageSize());
        List subList = list.subList(startIndex, endIndex);
        return new ResponseEntity<>(new PageImpl(subList, pageable, list.size()), HttpStatus.OK);
    }



    @GetMapping(value = "/user")
    public ResponseEntity<?> GetAllTimeKeepingByUser( Pageable pageable,int userId,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startTime,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endTime) {
        if(startTime == null){
            startTime = LocalDate.of(1900, 1, 1);
        }

        if(endTime == null){
            endTime = LocalDate.of(3000, 1, 1);
        }
        List<FormTimeKeeping> list = timekeepingService.getAllTimekeepingByUser(userId,startTime,endTime);
        if (pageable.getOffset() >= list.size()) {
            new ResponseEntity<>(Page.empty(), HttpStatus.OK);
        }
        int startIndex = (int)pageable.getOffset();
        int endIndex = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ?
                list.size() :
                pageable.getOffset() + pageable.getPageSize());
        List subList = list.subList(startIndex, endIndex);
        return new ResponseEntity<>(new PageImpl(subList, pageable, list.size()), HttpStatus.OK);
    }

    @GetMapping(value = "/payroll")
    public ResponseEntity<?> GetPayrollSheet(int month,int year,int userId){
        return new ResponseEntity<>(timekeepingService.PayrollSheets(month,year,userId),HttpStatus.OK);
    }

    @GetMapping(value = "/demo")
    public ResponseEntity<?> DEMO(){
        List<Timekeeping> timekeepings = timekeepingRepository.findAll();
        List<TimekeepingDto> timekeepingDtoList = new ArrayList<>();
        for(Timekeeping timekeeping:timekeepings){
            TimekeepingDto timekeepingDto = new TimekeepingDto(timekeeping);
            timekeepingDtoList.add(timekeepingDto);
        }
        return new ResponseEntity<>(timekeepings,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createTimekeeping( @RequestBody @Valid FormCreateTimekeeping FormCreateTimekeeping){
            timekeepingService.CreateTimekeeping(FormCreateTimekeeping);
            return new ResponseEntity<>("create timkeeping successfully",HttpStatus.OK);
    }


}
