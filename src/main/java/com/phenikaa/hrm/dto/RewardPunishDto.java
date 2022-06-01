package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.RewardPunish;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class RewardPunishDto implements Serializable {
    private  Long amount;
    private  String reason;
    private  int userId;
    private LocalDate day;

    public RewardPunishDto( RewardPunish rewardPunish) {
        amount= rewardPunish.getAmount();
        reason=rewardPunish.getReason();
        userId=rewardPunish.getUser().getId();
        day=rewardPunish.getDay();
    }

    public RewardPunishDto() {
    }

    public RewardPunish ToEntity(){
        RewardPunish rewardPunish = new RewardPunish();
        rewardPunish.setAmount(amount);
        rewardPunish.setReason(reason);
        rewardPunish.setDay(day);
        return rewardPunish;
    }


}
