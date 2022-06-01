package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.entity.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IEmailService {

	void sendNotification(String email,String contentx,String content) throws MessagingException, UnsupportedEncodingException;

	void sendRequestResetPasswordSuccessfully(String email,String newPassword) throws MessagingException, UnsupportedEncodingException;

	void sendEmailToNewUser(User user) throws MessagingException, UnsupportedEncodingException;


}
