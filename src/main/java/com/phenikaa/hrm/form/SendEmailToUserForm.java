package com.phenikaa.hrm.form;

import lombok.Data;

@Data
public class SendEmailToUserForm {
    private String content;
    private String subject;
    private String email;
}
