package com.icecreamdistributor.IceCream.dto.request;

import lombok.Data;

@Data
public class SignupRequestDto {

    private String username;
    private String email;
    private String password;

}
