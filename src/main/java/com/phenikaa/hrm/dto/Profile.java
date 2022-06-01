package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Profile implements Serializable {
    private  int id;
    private  String firstname;
    private  String lastname;
    private  String gender;
    private  Date dateOfBirth;
    private  String address;
    private  String email;
    private  Date workStartDate;
    private  String numberPhone;
    private  Long salary;
    private  String idCard;
    private  String departmentName;
    private int departmentId;
    private  String classify;

    public Profile(User user) {
        id=user.getId();
        firstname= user.firstname;;
        lastname=user.getLastname();
        gender=user.getGender();
        dateOfBirth=user.getDateOfBirth();
        address= user.getAddress();
        email= user.getEmail();
        workStartDate=user.getWorkStartDate();
        numberPhone=user.getNumberPhone();
        salary=user.getSalary();
        idCard=user.getIdCard();
        departmentName=user.getDepartment().getName();
        departmentId = user.getDepartment().getId();
        classify=user.getClassify();
    }
}
