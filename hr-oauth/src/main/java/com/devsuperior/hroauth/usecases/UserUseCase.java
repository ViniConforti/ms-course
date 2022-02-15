package com.devsuperior.hroauth.usecases;

import com.devsuperior.hroauth.domain.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserUseCase implements UserDetailsService {
    private final UserFeignClient userFeignClient;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();
        if (user == null)
            throw new UsernameNotFoundException("Email not found");
        return user;
    }
}
