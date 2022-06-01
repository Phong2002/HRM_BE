package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.ResetPassword;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResetPasswordDto implements Serializable {
    private final String token;
    private final Integer user_id;
    private final String userName;

    public ResetPasswordDto(ResetPassword resetPassword){
        this.token=resetPassword.getToken();
        this.user_id=resetPassword.getUser().getId();
        this.userName= resetPassword.getUser().getUsername();
    }

}
