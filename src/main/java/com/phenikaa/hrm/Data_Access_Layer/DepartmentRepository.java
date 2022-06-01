package com.phenikaa.hrm.Data_Access_Layer;

import com.phenikaa.hrm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> , JpaSpecificationExecutor<Department> {
    Department findById(int id);
    Department findByName(String name);
    boolean existsByName(String name);
    void deleteByIdIn(List<Integer> ids);

    @Query(value = "select count(u.id) from User u where u.department.id=?1")
    int countEmpByDepartmentId(int id);

}
