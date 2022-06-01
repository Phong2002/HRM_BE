package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.dto.DepartmentDto;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.form.filter.DepartmentFilterForm;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IDepartmentService {
    Page<DepartmentDto> GetAllDepartment(Pageable pageable,String search, DepartmentFilterForm departmentFilterForm);
    void CreatDepartment(Department department);
    Department findById(int id);
    Department findByDepartmentName(String name);
    void UpdateDepartment(Integer id,DepartmentDto dto);
    boolean ExistsByName(String name);
    void DeleteDepartments(List<Integer> ids);
}
