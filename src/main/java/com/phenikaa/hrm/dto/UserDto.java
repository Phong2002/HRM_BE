package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {
    private final String firstname;
    private final String lastname;
    private final String gender;
    private final Date dateOfBirth;
    private final String address;
    private final String email;
    private final String username;
    private final String password;
    private final Date workStartDate;
    private final String numberPhone;
    private final Long salary;
    private final String idCard;
    private final Integer departmentId;
    private final String classify;
    private final String role;

    public User ToEntity(){
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setGender(gender);
        user.setDateOfBirth(dateOfBirth);
        user.setAddress(address);
        user.setEmail(email);
        user.setWorkStartDate(workStartDate);
        user.setNumberPhone(numberPhone);
        user.setSalary(salary);
        user.setIdCard(idCard);
        user.setClassify(classify);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }



}
