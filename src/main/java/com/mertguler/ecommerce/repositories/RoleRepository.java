package com.mertguler.ecommerce.repositories;

import com.mertguler.ecommerce.model.AppRole;
import com.mertguler.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
