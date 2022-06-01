package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.Data_Access_Layer.ResetPasswordRepository;
import com.phenikaa.hrm.Data_Access_Layer.UserRepository;
import com.phenikaa.hrm.dto.ResetPasswordDto;
import com.phenikaa.hrm.entity.ResetPassword;
import com.phenikaa.hrm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@Transactional
@Service
public class ResetPasswordService implements IResetPasswordService{
    @Autowired
    ResetPasswordRepository resetPasswordRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @Override
    public List<ResetPasswordDto> GetAllResetPassword() {
        List<ResetPasswordDto> resetPasswordDtos = new ArrayList<>();

        for(ResetPassword rs: resetPasswordRepository.findAll()){
            ResetPasswordDto resetPasswordDto = new ResetPasswordDto(rs);
            resetPasswordDtos.add(resetPasswordDto);
        }

        return resetPasswordDtos;
    }


    @Override
    public void confirmRequestResetPassword(String token) throws MessagingException, UnsupportedEncodingException {
        // Create random new password
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String newPassword = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        ResetPassword resetPassword = resetPasswordRepository.findByToken(token);
        User user = resetPassword.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        resetPasswordRepository.deleteByToken(token);

        //send an email with new passwod
        emailService.sendRequestResetPasswordSuccessfully(user.getEmail(),newPassword);
    }

    @Override
    public void refuseRequestResetPassword(String token) {
        resetPasswordRepository.deleteByToken(token);
    }

    @Override
    public void createRequestResetPassword(String email) {
        final String newToken = UUID.randomUUID().toString();
        User user = userRepository.findByEmail(email);
        ResetPassword resetPassword = new ResetPassword();
        resetPassword.setToken(newToken);
        resetPassword.setUser(user);
        resetPasswordRepository.save(resetPassword);
    }

    @Override
    public boolean existsByUser_Email(String email) {
        return resetPasswordRepository.existsByUser_Email(email);
    }
}
