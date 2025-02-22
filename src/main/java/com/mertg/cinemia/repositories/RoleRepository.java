package com.mertg.cinemia.repositories;

import com.mertg.cinemia.model.AppRole;
import com.mertg.cinemia.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
