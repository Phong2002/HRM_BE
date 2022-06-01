package com.phenikaa.hrm.Data_Access_Layer;

import com.phenikaa.hrm.entity.RewardPunish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RewardPunishRepository extends JpaRepository<RewardPunish,Integer>, JpaSpecificationExecutor<Integer> {
    List<RewardPunish> findAll();
    List<RewardPunish> findAllByUser_Id(int id);
    List<RewardPunish> findAllByUser_IdAndDay(int userid, LocalDate day);
}
