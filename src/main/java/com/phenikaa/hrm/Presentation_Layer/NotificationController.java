package com.phenikaa.hrm.Presentation_Layer;

import com.phenikaa.hrm.Business_Logic_Layer.DepartmentService;
import com.phenikaa.hrm.Business_Logic_Layer.IEmailService;
import com.phenikaa.hrm.Business_Logic_Layer.IUserService;
import com.phenikaa.hrm.Business_Logic_Layer.NotificationService;
import com.phenikaa.hrm.dto.NotificationsDto;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.entity.Notifications;
import com.phenikaa.hrm.entity.User;
import com.phenikaa.hrm.form.SendEmailToUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/notifications")
@Validated
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    IEmailService emailService;

    @Autowired
    IUserService userService;

    @GetMapping()
    public ResponseEntity<?> GetAllNotification(Pageable pageable,
                                                @RequestParam(required = false) String search,
                                                Integer departmentId){
        return new ResponseEntity<>(notificationService.getAllNotification(pageable,search,departmentId), HttpStatus.OK);
    }

    @GetMapping(value = "/department/{id}")
    public ResponseEntity<?> GetNotificationByDepartmentId(@PathVariable(name = "id") int id ){
        return new ResponseEntity<>(notificationService.GetNotificationByDepartmentId(id),HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<?> GetNotificationByUserId(@PathVariable(name = "id") int id){
        User user = userService.findUserById(id);
        int departmentID = user.getDepartment().getId();
        return new ResponseEntity<>(notificationService.GetNotificationByDepartmentId(departmentID),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> CreateNotification(@Valid @RequestBody NotificationsDto dto){
        Department department = departmentService.findById(dto.getDepartmentId());
        Notifications notifications = dto.ToEntity();
        notifications.setDepartment(department);
        notifications.setSentdate(new Date());
        notificationService.CreateNotification(notifications);
        return new ResponseEntity<>("Create Successfully ! ",HttpStatus.CREATED);
    }

    @PostMapping (value = "/sendemail")
    public ResponseEntity<?> sendNotificationToEmail(@Valid @RequestBody SendEmailToUserForm form) throws MessagingException, UnsupportedEncodingException {
        emailService.sendNotification(form.getEmail(),form.getSubject(),form.getContent());
        return new ResponseEntity<>("Send succesfully",HttpStatus.OK);
    }


}
