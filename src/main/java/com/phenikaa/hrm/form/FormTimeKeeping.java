package com.phenikaa.hrm.form;

import com.phenikaa.hrm.dto.MonthAndYear;
import com.phenikaa.hrm.dto.TimekeepingDto;
import com.phenikaa.hrm.entity.Timekeeping;
import com.phenikaa.hrm.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormTimeKeeping implements Serializable {
    private User user;
    private MonthAndYear monthAndYear;
    private int totalHourWork;
    private int totalHourOT;
    private long totalRP;
    private long totalSalary;

    public FormTimeKeeping(User user, MonthAndYear monthAndYear,List<TimekeepingDto> timekeepingDtoList, Long totalRP) {
        for(TimekeepingDto timekeepingDto: timekeepingDtoList){
            this.totalHourWork+= timekeepingDto.getHours();
            this.totalHourOT+=timekeepingDto.getOverTime();
        }
        this.user = user;
        this.monthAndYear = monthAndYear;
        this.totalRP = totalRP;
        this.totalSalary = TotalSalarys();
    }
    public long TotalSalarys(){
        long salary =0;
        salary+=(user.getSalary()/160)*totalHourWork;
        salary+=((user.getSalary()/160)*totalHourOT)*2;
        salary+=totalRP;
        return salary;
    }
}
