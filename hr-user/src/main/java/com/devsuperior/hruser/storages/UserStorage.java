package com.devsuperior.hruser.storages;

import com.devsuperior.hruser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStorage extends JpaRepository<User,Long> {
    // É bom sempre usar o nome findBy na assinatura do método, assim o jpa interpreta como uma query.
    User findByEmail(String email);
}
