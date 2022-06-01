package com.phenikaa.hrm.Presentation_Layer;


import com.phenikaa.hrm.Business_Logic_Layer.IDepartmentService;
import com.phenikaa.hrm.dto.DepartmentDto;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.form.filter.DepartmentFilterForm;
import com.phenikaa.hrm.form.filter.UserFilterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/departments")
@Validated
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<?> GetAllDepartments(Pageable pageable,
                                               @RequestParam(required = false) String search,
                                               DepartmentFilterForm filter){
        return new ResponseEntity<>(departmentService.GetAllDepartment(pageable,search,filter), HttpStatus.OK);
    }

    @GetMapping(value = "/departmentname/{departmentname}")
    public ResponseEntity<?> ExistByName(@PathVariable(name = "departmentname") String departmentName){
        return new ResponseEntity<>(departmentService.ExistsByName(departmentName),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto dto){
        Department department = dto.ToEntity();
        departmentService.CreatDepartment(department);
        return new ResponseEntity<>("create successfully!",HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable(name = "id") Integer id, @RequestBody DepartmentDto dto) {
        departmentService.UpdateDepartment(id,dto);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{ids}")
    public ResponseEntity<?> deleteGroups(@PathVariable(name = "ids") List<Integer> ids) {
        departmentService.DeleteDepartments(ids);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }

}
