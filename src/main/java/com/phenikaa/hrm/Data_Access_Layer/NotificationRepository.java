package com.phenikaa.hrm.Data_Access_Layer;

import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.entity.Notifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notifications,Integer>, JpaSpecificationExecutor<Notifications> {
    List<Notifications> findByDepartment_Id(int id);
}
