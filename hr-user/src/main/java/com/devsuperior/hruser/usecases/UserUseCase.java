package com.devsuperior.hruser.usecases;

import com.devsuperior.hruser.domain.User;
import com.devsuperior.hruser.storages.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCase {
    private final UserStorage userStorage;

    public User findById(Long id){
        return userStorage.findById(id).get();
    }

    public User findByEmail(String email){
        return userStorage.findByEmail(email);
    }
}
