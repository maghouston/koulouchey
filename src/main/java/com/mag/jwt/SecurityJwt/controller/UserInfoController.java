package com.mag.jwt.SecurityJwt.controller;

import com.mag.jwt.SecurityJwt.model.UserInfo;
import com.mag.jwt.SecurityJwt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
public class UserInfoController {

    private UserInfoRepository userInfoRepository;

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @PostMapping("/user")
    public Boolean create(@RequestBody UserInfo body) throws NoSuchAlgorithmException {
        String username = body.getUsername();
        if (userInfoRepository.existsByUsername(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        body.setPassword(encodedPassword);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        userInfoRepository.save(body);
        return true;
    }




}
