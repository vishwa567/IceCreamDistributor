package com.icecreamdistributor.IceCream.service.impl;

import com.icecreamdistributor.IceCream.dto.request.LoginRequestDto;
import com.icecreamdistributor.IceCream.dto.request.SignupRequestDto;
import com.icecreamdistributor.IceCream.dto.response.LoginResponseDto;
import com.icecreamdistributor.IceCream.dto.response.SignupResponseDto;
import com.icecreamdistributor.IceCream.entity.Users;
import com.icecreamdistributor.IceCream.entity.type.RoleType;
import com.icecreamdistributor.IceCream.mapper.LoginMapper;
import com.icecreamdistributor.IceCream.mapper.SignupMapper;
import com.icecreamdistributor.IceCream.repository.UsersRepository;
import com.icecreamdistributor.IceCream.security.AuthUtil;
import com.icecreamdistributor.IceCream.security.CustomUserDetails;
import com.icecreamdistributor.IceCream.service.IUsersService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService implements IUsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final SignupMapper signupMapper;
    private final LoginMapper loginMapper;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;


    @Override
    public SignupResponseDto createNewUser(SignupRequestDto request) {

        if (request == null || request.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Enter the requested data");
        }

        Users user = usersRepository.findByEmail(request.getEmail()).orElse(null);

        if (user != null) {
            throw new EntityExistsException("Email " + request.getEmail() + " already exist");
        }

        user = Users.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleType.DISTRIBUTOR)
                .build();


        Users savedUser = usersRepository.save(user);

        return signupMapper.toResponseDto(savedUser);
    }

    @Override
    public LoginResponseDto validateUser(LoginRequestDto request) {


        if (request == null || request.getEmail() == null) {
            throw new IllegalArgumentException("Enter the requested data");
        }

        Authentication authRequest = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authRequest);

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        Users user = customUserDetails.user();
        String token = authUtil.generateToken(user);

        return loginMapper.toResponseDto(user, token);

    }
}
