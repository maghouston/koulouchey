package com.mag.jwt.SecurityJwt.mapper;

import com.mag.jwt.SecurityJwt.dto.UserDTO;
import com.mag.jwt.SecurityJwt.model.UserInfo;

public class UserMapper {

   public static UserDTO map(UserInfo userInfo) {
       if(userInfo != null) {
           UserDTO userDTO = new UserDTO();
           userDTO.setEmail(userInfo.getEmail());
           userDTO.setFullname(userInfo.getFullname());
           userDTO.setId(userInfo.getId());
           userDTO.setTelephone(userInfo.getTelephone());
           userDTO.setUsername(userInfo.getUsername());
           userDTO.setAdresse(AdresseMapper.map(userInfo.getAdresse()));
           return userDTO;
       }
        return null;
    }
}
