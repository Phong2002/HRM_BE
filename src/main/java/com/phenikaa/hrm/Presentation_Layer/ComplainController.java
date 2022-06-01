package com.phenikaa.hrm.Presentation_Layer;

import com.phenikaa.hrm.Business_Logic_Layer.IComplainService;
import com.phenikaa.hrm.dto.ComplainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/complains")
@Validated
public class ComplainController {
    @Autowired
    IComplainService complainService;

    @GetMapping()
    public ResponseEntity<?> GetAllComplain(){
        return new ResponseEntity<>(complainService.GetAllComplain(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> CreateComplain(@Valid @RequestBody ComplainDto dto){
        complainService.CreateComplain(dto);
        return new ResponseEntity<>("Create complain successfully !",HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> GetComplainByUserId(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(complainService.GetComplainByUserId(id),HttpStatus.OK);
    }
}
