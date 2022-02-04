package com.devsuperior.hroauth.usecases;

import com.devsuperior.hroauth.domain.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserUseCase {
    private final UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        log.info("Email found: " + email);
        return user;
    }
}
