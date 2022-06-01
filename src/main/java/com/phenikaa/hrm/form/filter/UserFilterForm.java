package com.phenikaa.hrm.form.filter;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserFilterForm {
private String classify;
private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
private Date minWorkStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
private Date maxWorkStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
private Date minBirthDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
private Date maxBirthDay;
}
