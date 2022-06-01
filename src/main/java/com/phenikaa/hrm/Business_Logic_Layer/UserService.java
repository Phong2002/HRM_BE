package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.Business_Logic_Layer.Specification.UserSpecification;
import com.phenikaa.hrm.Data_Access_Layer.DepartmentRepository;
import com.phenikaa.hrm.Data_Access_Layer.UserRepository;
import com.phenikaa.hrm.dto.AccountDto;
import com.phenikaa.hrm.dto.UserDto;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.entity.User;
import com.phenikaa.hrm.form.filter.UserFilterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Page<User> getAll(Pageable pageable, String search, UserFilterForm filter) {
        Specification<User> where = null;

        if (!StringUtils.isEmpty(search)) {
            UserSpecification firstNameSpecification = new UserSpecification("fullName", "%LIKE%", search);

            UserSpecification addressSpecification = new UserSpecification("address", "=",search);
            where = Specification.where(firstNameSpecification).or(addressSpecification);
        }

        if(filter != null && filter.getClassify() != null){
            UserSpecification filterClassify = new UserSpecification("classify","=",filter.getClassify());
            if(where==null){
                where = Specification.where(filterClassify);
            }
            else{
                where = where.and(filterClassify);
            }
        }

        if(filter != null && filter.getGender()!=null){
            UserSpecification filterGender = new UserSpecification("gender","=",filter.getGender());
            if(where==null){
                where = Specification.where(filterGender);
            }
            else{
                where = where.and(filterGender);
            }
        }

        if(filter != null && filter.getMinBirthDay()!=null){
            UserSpecification filterMinBirthDay = new UserSpecification("dateOfBirth",">=",filter.getMinBirthDay());
            if(where == null){
                where = Specification.where(filterMinBirthDay);
            }
            else{
                where = where.and(filterMinBirthDay);
            }
        }

        if(filter !=null && filter.getMaxBirthDay()!=null){
            UserSpecification filterMaxBirthDay = new UserSpecification("dateOfBirth", "<=", filter.getMaxBirthDay());
            if(where == null) {
                where = Specification.where(filterMaxBirthDay);
            }
            else {
                where = where.and(filterMaxBirthDay);
            }
        }

        if(filter !=null && filter.getMinWorkStartDate() !=null){
            UserSpecification filterMinWorkStartDate = new UserSpecification("workStartDate",">=",filter.getMinWorkStartDate());
                    if(where == null){
                        where = Specification.where(filterMinWorkStartDate);
                    }
                    else{
                        where = where.and(filterMinWorkStartDate);
                    }
        }

        if(filter !=null && filter.getMaxWorkStartDate() !=null){
            UserSpecification filterMaxWorkStartDate = new UserSpecification("workStartDate","<=",filter.getMaxWorkStartDate());
            if(where == null){
                where = Specification.where(filterMaxWorkStartDate);
            }
            else{
                where = where.and(filterMaxWorkStartDate);
            }
        }


        return userRepository.findAll(where,pageable);
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByUserName(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsUserByUserName(String userName) {
        return userRepository.existsByUsername(userName);
    }


    @Override
    public void updateUser(int id, UserDto dto) {
        User user = userRepository.findById(id);
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setGender(dto.getGender());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setWorkStartDate(dto.getWorkStartDate());
        user.setNumberPhone(dto.getNumberPhone());
        user.setSalary(dto.getSalary());
        user.setIdCard(dto.getIdCard());
        int departmentId = dto.getDepartmentId();
        Department department = departmentRepository.findById(departmentId);
        user.setDepartment(department);
        user.setClassify(dto.getClassify());
    }

    @Override
    public List<AccountDto> accountList() {
        List<User>userList=userRepository.findAll();
        List<AccountDto> accountList= new ArrayList<>();
        for(User user:userList){
            AccountDto newAccount = new AccountDto(user);
            accountList.add(newAccount);
        }
        return  accountList;
    }

    @Override
    public void DeleteUsers(List<Integer> ids) {
        userRepository.deleteByIdIn(ids);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check user exists by username
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole()));
    }
}
