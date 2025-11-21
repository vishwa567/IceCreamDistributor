package com.icecreamdistributor.IceCream.security;

import com.icecreamdistributor.IceCream.entity.Users;
import com.icecreamdistributor.IceCream.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(username).orElse(null);

        if(user == null) {
            throw new UsernameNotFoundException("User not Found");
        }

        return new CustomUserDetails(user);

    }
}
