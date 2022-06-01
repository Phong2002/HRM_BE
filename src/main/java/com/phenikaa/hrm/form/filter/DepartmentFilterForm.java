package com.phenikaa.hrm.form.filter;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class DepartmentFilterForm {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
private Date minFoundingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
private Date maxFoundingDate;
private int minTotalMember;
private int maxTotalMember;

}
