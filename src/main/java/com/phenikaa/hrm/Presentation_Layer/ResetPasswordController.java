package com.phenikaa.hrm.Presentation_Layer;

import com.phenikaa.hrm.Business_Logic_Layer.IResetPasswordService;
import com.phenikaa.hrm.Business_Logic_Layer.IUserService;
import com.phenikaa.hrm.Business_Logic_Layer.ResetPasswordService;
import com.phenikaa.hrm.entity.ResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/resetpassword")
public class ResetPasswordController {
   @Autowired
    IResetPasswordService resetPasswordService;

   @Autowired
    IUserService userService;

    @GetMapping()
    public ResponseEntity<?> GetAllResetPassword(){
        return new ResponseEntity<>(resetPasswordService.GetAllResetPassword(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/confirm/{token}")
    public ResponseEntity<?> ConfirmRequest(@PathVariable(name = "token") String token) throws MessagingException, UnsupportedEncodingException {
        resetPasswordService.confirmRequestResetPassword(token);
        return new ResponseEntity<>("Confirm request successfully ",HttpStatus.OK);
    }

    @DeleteMapping(value = "/refuse/{token}")
    public ResponseEntity<?> RefuseRequest (@PathVariable(name = "token") String token){
        resetPasswordService.refuseRequestResetPassword(token);
        return new ResponseEntity<>("Refuse request successfully",HttpStatus.OK);
    }

    @PostMapping(value = "/{email}")
    public ResponseEntity<?> CreateRequestResetPassword(@PathVariable(name = "email") String email ){
        if(!userService.existsUserByEmail(email)){
            return new ResponseEntity<>("Email is not exist",HttpStatus.BAD_REQUEST);
        }
        if(resetPasswordService.existsByUser_Email(email)){
            return new ResponseEntity<>("This email has asked for a password reset!",HttpStatus.ALREADY_REPORTED);
        }

        resetPasswordService.createRequestResetPassword(email);
        return new ResponseEntity<>("Create request successfully",HttpStatus.OK);
    }
}
