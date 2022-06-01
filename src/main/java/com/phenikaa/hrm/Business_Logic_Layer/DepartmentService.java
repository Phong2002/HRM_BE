package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.Business_Logic_Layer.Specification.DepartmentSpecification;
import com.phenikaa.hrm.Business_Logic_Layer.Specification.UserSpecification;
import com.phenikaa.hrm.Data_Access_Layer.DepartmentRepository;
import com.phenikaa.hrm.dto.DepartmentDto;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.entity.User;
import com.phenikaa.hrm.form.filter.DepartmentFilterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.function.Function;

@Component
@Transactional
@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public Page<DepartmentDto> GetAllDepartment(Pageable pageable,String search, DepartmentFilterForm filter) {

        Specification<Department> where = null;

        if (!StringUtils.isEmpty(search)) {
            DepartmentSpecification nameSpecification = new DepartmentSpecification("name", "%LIKE%", search);
            where = Specification.where(nameSpecification);
        }

        if(filter != null && filter.getMinFoundingDate() != null){
            DepartmentSpecification filterMinFoundingDate = new DepartmentSpecification("foundingDate",">=",filter.getMinFoundingDate());
            if(where==null){
                where = Specification.where(filterMinFoundingDate);
            }
            else{
                where = where.and(filterMinFoundingDate);
            }
        }

        if(filter != null && filter.getMaxFoundingDate() != null){
            DepartmentSpecification filterMaxFoundingDate = new DepartmentSpecification("foundingDate","<=",filter.getMaxFoundingDate());
            if(where==null){
                where = Specification.where(filterMaxFoundingDate);
            }
            else{
                where = where.and(filterMaxFoundingDate);
            }
        }

        if(filter != null && filter.getMinTotalMember() != 0){
            DepartmentSpecification filterMinTotalMember = new DepartmentSpecification("minTotalMember",">=",filter.getMinTotalMember());
            if(where==null){
                where = Specification.where(filterMinTotalMember);
            }
            else{
                where = where.and(filterMinTotalMember);
            }
        }

        if(filter != null && filter.getMaxTotalMember() != 0){
            DepartmentSpecification filterMaxTotalMember = new DepartmentSpecification("maxTotalMember","<=",filter.getMaxTotalMember());
            if(where==null){
                where = Specification.where(filterMaxTotalMember);
            }
            else{
                where = where.and(filterMaxTotalMember);
            }
        }


        Page<Department> departments = departmentRepository.findAll(where,pageable);

        Page<DepartmentDto> departmentDtos = departments.map(new Function<Department, DepartmentDto>() {
            @Override
            public DepartmentDto apply(Department department) {
                DepartmentDto departmentDto = new DepartmentDto(department);
                departmentDto.setTotalMember(departmentRepository.countEmpByDepartmentId(department.getId()));
                return departmentDto;
            }
        });

        return departmentDtos;
    }



    @Override
    public void CreatDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department findByDepartmentName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    @Transactional
    public void UpdateDepartment(Integer id, DepartmentDto dto) {
        Department department = findById(id);
        department.setName(dto.getName());
        department.setIntroduce(dto.getIntroduce());
        department.setFoundingDate(dto.getFoundingDate());
        departmentRepository.save(department);
    }

    @Override
    public boolean ExistsByName(String name) {
        return departmentRepository.existsByName(name);
    }

    @Override
    @Transactional
    public void DeleteDepartments(List<Integer> ids) {
        departmentRepository.deleteByIdIn(ids);
    }
}
