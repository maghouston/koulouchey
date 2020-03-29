package com.mag.jwt.SecurityJwt.repository;

import com.mag.jwt.SecurityJwt.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Boolean existsByUsername(String username);
    UserInfo findByUsername(String username);
}
