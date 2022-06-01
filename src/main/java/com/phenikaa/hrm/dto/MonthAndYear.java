package com.phenikaa.hrm.dto;

import lombok.Data;

@Data
public class MonthAndYear {
    private int month;
    private int year;

    public MonthAndYear(int month, int year) {
        this.month = month;
        this.year = year;
    }
}
