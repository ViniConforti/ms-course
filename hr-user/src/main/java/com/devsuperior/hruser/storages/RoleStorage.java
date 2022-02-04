package com.devsuperior.hruser.storages;

import com.devsuperior.hruser.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleStorage extends JpaRepository<Role,Long> {}
