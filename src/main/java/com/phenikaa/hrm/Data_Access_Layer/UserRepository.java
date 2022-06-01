package com.phenikaa.hrm.Data_Access_Layer;

import com.phenikaa.hrm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    boolean existsByUsername(String userName);

    boolean existsByEmail(String email);

    User findByUsername(String name);

    User findByEmail(String email);

    User findById(int id);

    void deleteByIdIn(List<Integer> ids);



}

