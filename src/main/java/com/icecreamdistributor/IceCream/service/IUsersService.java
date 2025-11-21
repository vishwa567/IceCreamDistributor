package com.icecreamdistributor.IceCream.service;

import com.icecreamdistributor.IceCream.dto.request.LoginRequestDto;
import com.icecreamdistributor.IceCream.dto.request.SignupRequestDto;
import com.icecreamdistributor.IceCream.dto.response.LoginResponseDto;
import com.icecreamdistributor.IceCream.dto.response.SignupResponseDto;

public interface IUsersService {
    SignupResponseDto createNewUser(SignupRequestDto request);
    LoginResponseDto validateUser(LoginRequestDto request);
}
