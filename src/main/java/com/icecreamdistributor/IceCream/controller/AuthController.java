package com.icecreamdistributor.IceCream.controller;

import com.icecreamdistributor.IceCream.dto.request.LoginRequestDto;
import com.icecreamdistributor.IceCream.dto.request.SignupRequestDto;
import com.icecreamdistributor.IceCream.dto.response.LoginResponseDto;
import com.icecreamdistributor.IceCream.dto.response.SignupResponseDto;
import com.icecreamdistributor.IceCream.service.impl.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto request) {
        return ResponseEntity.ok(usersService.createNewUser(request));

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(usersService.validateUser(request));
    }

}
