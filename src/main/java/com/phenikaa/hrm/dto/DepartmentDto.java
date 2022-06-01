package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.Department;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto implements Serializable {
    private  int id=0;
    @NotNull
    private  String name="";
    @NotNull
    private  String introduce=null;
    @NotNull
    private  Date foundingDate=null;
    private int totalMember=0;

    public Department ToEntity(){
        Department department = new Department();
        department.setName(name);
        department.setIntroduce(introduce);
        department.setFoundingDate(foundingDate);
        return department;
    }

    public DepartmentDto(Department department){
        this.id = department.getId();
        this.name = department.getName();
        this.introduce = department.getIntroduce();
        this.foundingDate = department.getFoundingDate();
    }
}
