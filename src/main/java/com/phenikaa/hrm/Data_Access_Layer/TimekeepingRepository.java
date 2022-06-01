package com.phenikaa.hrm.Data_Access_Layer;
import com.phenikaa.hrm.entity.Timekeeping;
import com.phenikaa.hrm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface TimekeepingRepository extends JpaRepository<Timekeeping,Integer>, JpaSpecificationExecutor<Timekeeping> {
List<Timekeeping> findAll();
@Query(value = "SELECT t.user FROM Timekeeping t where t.user.fullName like %?1% group by t.user")
    List<User> selectUser(String search);

@Query(value = "select t.workday from Timekeeping t where t.user.fullName like %?1% and t.workday >= ?2 and t.workday<= ?3 group by month(t.workday),year(t.workday) order by t.workday asc")
    List<LocalDate> selectDate(String search, LocalDate startTime, LocalDate endTime);

@Query(value = "select t.workday from Timekeeping t where t.user.id = ?1 and t.workday >= ?2 and t.workday<= ?3 group by month(t.workday),year(t.workday) order by t.workday asc")
    List<LocalDate> selectDateByUser(int userId, LocalDate startTime, LocalDate endTime);

@Query(value = "select t from Timekeeping t where month(t.workday)=?1 and year(t.workday)=?2 and t.user.id = ?3")
    List<Timekeeping> getTimekeepingByDateAndUserId(int month,int year,int userID);

@Query(value = "SELECT sum(r.amount) from RewardPunish r where r.user.id = ?1 and month(r.day) = ?2 and year(r.day) = ?3")
    Long totalRewarPunish(int userId,int month,int year);

@Query(value = "select t from Timekeeping t where month(t.workday) = ?1 and year(t.workday) = ?2 and t.user.id =?3 order by t.workday asc")
    List<Timekeeping> selectPayrollByUser(int month,int year,int user);

}

