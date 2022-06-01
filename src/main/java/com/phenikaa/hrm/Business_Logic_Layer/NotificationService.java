package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.Business_Logic_Layer.Specification.DepartmentSpecification;
import com.phenikaa.hrm.Business_Logic_Layer.Specification.NotifySpecification;
import com.phenikaa.hrm.Data_Access_Layer.DepartmentRepository;
import com.phenikaa.hrm.Data_Access_Layer.NotificationRepository;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.entity.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Component
@Transactional
@Service
public class NotificationService implements INotificationService{
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Page<Notifications> getAllNotification(Pageable pageable, String search, Integer departmentId) {
        Specification<Notifications> where = null;

        if (!StringUtils.isEmpty(search)) {
            NotifySpecification nameSpecification = new NotifySpecification("title", "%LIKE%", search);
            where = Specification.where(nameSpecification);
        }

        if(departmentId != null ){
            Department department = departmentRepository.findById((int)departmentId);
            NotifySpecification filterDepartment = new NotifySpecification("department","=",department);
            if(where==null){
                where = Specification.where(filterDepartment);
            }
            else{
                where = where.and(filterDepartment);
            }
        }
        return notificationRepository.findAll(where,pageable);
    }

    @Override
    public List<Notifications> GetNotificationByDepartmentId(int id) {
        return notificationRepository.findByDepartment_Id(id);
    }

    @Override
    public void CreateNotification(Notifications notifications) {
        notificationRepository.save(notifications);
    }
}
