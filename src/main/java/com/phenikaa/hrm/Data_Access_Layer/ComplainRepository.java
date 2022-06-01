package com.phenikaa.hrm.Data_Access_Layer;

import com.phenikaa.hrm.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplainRepository extends JpaRepository<Complain,Integer>, JpaSpecificationExecutor<Integer> {
    List<Complain> findAll();
    List<Complain> findByUser_Id(int id);



}
