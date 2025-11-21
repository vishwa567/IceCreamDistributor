package com.icecreamdistributor.IceCream.mapper;

import com.icecreamdistributor.IceCream.dto.response.SignupResponseDto;
import com.icecreamdistributor.IceCream.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class SignupMapper {

    public SignupResponseDto toResponseDto(Users user) {
        return SignupResponseDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

}
