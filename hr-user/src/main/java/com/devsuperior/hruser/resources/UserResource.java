package com.devsuperior.hruser.resources;

import com.devsuperior.hruser.domain.User;
import com.devsuperior.hruser.usecases.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserResource {

    private final UserUseCase userUseCase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
      User user = userUseCase.findById(id);
      return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = userUseCase.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
