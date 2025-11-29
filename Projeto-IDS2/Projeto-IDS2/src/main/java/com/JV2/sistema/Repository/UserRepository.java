package com.JV2.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JV2.sistema.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // aqui você pode criar queries personalizadas depois
}
