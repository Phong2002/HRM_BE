package com.phenikaa.hrm.dto;


import com.phenikaa.hrm.entity.RewardPunish;
import com.phenikaa.hrm.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class Salary {
    private User user;
    private Long totalWorkingHours;
    private Long totalOTHours;
    private double totalRP;
    private double totalAmount;

    public Salary(User user,List<TimekeepingDto> timekeepingDtoList, List<RewardPunish> rewardPunishList) throws ParseException {
        for(TimekeepingDto timekeeping:timekeepingDtoList){
            totalWorkingHours+=timekeeping.getHours();
            totalOTHours+=timekeeping.getOverTime();
        }
        for(RewardPunish rewardPunish:rewardPunishList){
            totalRP+=rewardPunish.getAmount();
        }

        totalAmount=user.getSalary()/160*(totalWorkingHours/3600000)+(totalOTHours/3600000)*user.getSalary()/160*1.25;

    }

}

