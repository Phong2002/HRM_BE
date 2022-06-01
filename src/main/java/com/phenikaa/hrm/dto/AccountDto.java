package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountDto implements Serializable {
    private  int id;
    private  String userName;
    private  String fullName;

    public AccountDto(User user){
        this.id=user.getId();
        this.userName= user.getUsername();
        this.fullName=user.getFirstname()+" "+ user.getLastname();
    }
}
