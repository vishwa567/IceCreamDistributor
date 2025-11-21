package com.icecreamdistributor.IceCream.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {

    private String username;
    private Long userId;
    private String token;

}
