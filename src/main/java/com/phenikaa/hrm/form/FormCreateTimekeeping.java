package com.phenikaa.hrm.form;

import com.phenikaa.hrm.entity.Timekeeping;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class FormCreateTimekeeping implements Serializable {
    private  int userId;
    private LocalTime startTime;
    private  LocalTime timeEnd;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate workday;

    public Timekeeping toTimekeeping(){
        Timekeeping timekeeping = new Timekeeping();
        timekeeping.setStartTime(startTime);
        timekeeping.setTimeEnd(timeEnd);
        timekeeping.setWorkday(workday);
        return timekeeping;
    }
}
