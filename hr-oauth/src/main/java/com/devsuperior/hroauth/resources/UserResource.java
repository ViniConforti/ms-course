package com.devsuperior.hroauth.resources;

import com.devsuperior.hroauth.domain.User;
import com.devsuperior.hroauth.usecases.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserResource {

    private final UserUseCase userUseCase;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        try {
            User user = userUseCase.findByEmail(email);
            return ResponseEntity.ok(user);
        }
        catch (IllegalArgumentException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
