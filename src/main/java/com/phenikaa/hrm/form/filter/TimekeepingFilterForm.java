package com.phenikaa.hrm.form.filter;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TimekeepingFilterForm {
    private String startDate;
    private String endDate;
}
