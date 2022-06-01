package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.Timekeeping;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TimekeepingDto implements Serializable {
    @NotNull
    private final int userId;
    @NotNull
    private final LocalTime startTime;
    @NotNull
    private final LocalTime timeEnd;
    @NotNull
    private final LocalDate day;
    private  Long hours;
    private  Long overTime;

    public TimekeepingDto(Timekeeping timekeeping){
        this.userId=timekeeping.getUser().getId();
        this.startTime=timekeeping.getStartTime();
        this.timeEnd=timekeeping.getTimeEnd();
        this.day=timekeeping.getWorkday();
        setHoursAndOT();
    }

    private void setHoursAndOT(){
        Long hour =Math.abs(Duration.between(startTime,timeEnd).toHours());
        int lunch=0;
        if(startTime.getHour()<12&&timeEnd.getHour()>=13){
            lunch=1;
        }
        hour+=(Math.abs(Duration.between(startTime,timeEnd).toMinutes()%60)>=30)?1:0;
        hour-=lunch;
        hours=hour>8?8:hour;
        overTime=(hour<=8?0:(hour-8));
    }

}
