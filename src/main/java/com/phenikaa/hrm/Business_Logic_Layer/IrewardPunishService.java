package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.dto.RewardPunishDto;
import com.phenikaa.hrm.entity.RewardPunish;

import java.util.List;

public interface IrewardPunishService {
    List<RewardPunish> getAllRewardPunish();
    List<RewardPunish> getRewardPunishByUserId(int id);
    void CreateRewardPunish(RewardPunishDto dto);
}
