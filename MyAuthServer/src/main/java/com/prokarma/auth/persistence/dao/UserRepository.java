package com.prokarma.auth.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prokarma.auth.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}
