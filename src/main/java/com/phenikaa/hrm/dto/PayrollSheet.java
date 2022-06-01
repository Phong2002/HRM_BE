package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.RewardPunish;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
public class PayrollSheet implements Serializable {
    private LocalTime startTime;
    private  LocalTime timeEnd;
    private LocalDate day;
    private  Long hours;
    private  Long overTime;
    private List<RewardPunishDto> rewardPunishs;
    private Long wage;

    public PayrollSheet(TimekeepingDto timekeeping,List<RewardPunishDto> rewardPunishs,Long salary ) {
        startTime=timekeeping.getStartTime();
        timeEnd=timekeeping.getTimeEnd();
        day=timekeeping.getDay();
        hours=timekeeping.getHours();
        overTime=timekeeping.getOverTime();
        this.rewardPunishs=rewardPunishs;
        this.wage=TotalWage(salary);

    }

    public long TotalWage(Long salary){
        long wage =0;
        wage+=(salary/160)*hours;
        wage+=(salary/160)*overTime*2;
        long totalRP=0;
        for(RewardPunishDto rewardPunishDto:rewardPunishs){
            totalRP+=rewardPunishDto.getAmount();
        }
        wage+=totalRP;
        return wage;
    }


}
