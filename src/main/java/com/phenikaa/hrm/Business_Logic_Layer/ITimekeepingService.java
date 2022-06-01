package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.dto.PayrollSheet;
import com.phenikaa.hrm.form.FormCreateTimekeeping;
import com.phenikaa.hrm.form.FormTimeKeeping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITimekeepingService {
    List<FormTimeKeeping> getAllTimekeeping(String search, LocalDate startTime, LocalDate timeEnd);
    List<FormTimeKeeping> getAllTimekeepingByUser(int userId, LocalDate startTime, LocalDate timeEnd);
    List<PayrollSheet> PayrollSheets(int month,int year,int userId);
    void CreateTimekeeping(FormCreateTimekeeping FormCreateTimekeeping);

}
