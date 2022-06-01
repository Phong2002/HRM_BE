package com.phenikaa.hrm.Data_Access_Layer;

import com.phenikaa.hrm.entity.ResetPassword;
import com.phenikaa.hrm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
public interface ResetPasswordRepository extends JpaRepository<ResetPassword,Integer>, JpaSpecificationExecutor<Integer> {
    List<ResetPassword> findAll();
    ResetPassword findByToken(String token);
    boolean existsByUserId(int id);
    void deleteByToken(String token);
    boolean existsByUser_Email(String email);
}
