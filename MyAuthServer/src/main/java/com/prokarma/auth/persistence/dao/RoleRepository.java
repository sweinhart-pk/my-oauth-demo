package com.prokarma.auth.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.auth.persistence.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
