package com.icecreamdistributor.IceCream.mapper;

import com.icecreamdistributor.IceCream.dto.response.LoginResponseDto;
import com.icecreamdistributor.IceCream.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public LoginResponseDto toResponseDto(Users user, String token) {
        return LoginResponseDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .token(token)
                .build();
    }

}
