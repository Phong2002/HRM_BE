package com.phenikaa.hrm.Presentation_Layer;


import com.phenikaa.hrm.Business_Logic_Layer.IDepartmentService;
import com.phenikaa.hrm.Business_Logic_Layer.IEmailService;
import com.phenikaa.hrm.Business_Logic_Layer.IUserService;
import com.phenikaa.hrm.dto.Profile;
import com.phenikaa.hrm.dto.UserDto;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.entity.User;
import com.phenikaa.hrm.form.filter.UserFilterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/users")
@Validated
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IDepartmentService departmentService;
    @Autowired
    IEmailService emailService;



    @GetMapping()
    public ResponseEntity<?> GetAllUsers(Pageable pageable,
                                         @RequestParam(required = false) String search,
                                         UserFilterForm filter){
        return new ResponseEntity<>(userService.getAll(pageable,search,filter), HttpStatus.OK);
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<?> existsUserByEmail(@PathVariable(name = "email") String email) {
        // get entity
        boolean result = userService.existsUserByEmail(email);

        // return result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<?> existsUserByUserName(@PathVariable(name = "username") String userName) {
        // get entity
        boolean result = userService.existsUserByUserName(userName);
        // return result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto dto) throws MessagingException, UnsupportedEncodingException {
        // create User
        Department department = departmentService.findById(dto.getDepartmentId());
        User user = dto.ToEntity();
        user.setDepartment(department);
        userService.createUser(user);
        emailService.sendEmailToNewUser(user);
        return new ResponseEntity<>("Create account successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") short id,@RequestBody UserDto dto) {
        userService.updateUser(id,dto);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @GetMapping(value = "/account")
    public ResponseEntity<?> getAllAccount(){
        return new ResponseEntity<>(userService.accountList(),HttpStatus.OK);
    }

   @GetMapping(value = "profile/{id}")
    public ResponseEntity<?> GetProfile(@PathVariable(name = "id") short id){
        User user = userService.findUserById(id);
       Profile profile = new Profile(user);
        return new ResponseEntity<>(profile,HttpStatus.OK);
   }

    @DeleteMapping(value = "/{ids}")
    public ResponseEntity<?> deleteUsers(@PathVariable(name = "ids") List<Integer> ids) {
        userService.DeleteUsers(ids);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }





}
