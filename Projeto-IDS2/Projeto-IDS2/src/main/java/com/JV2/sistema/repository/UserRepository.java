package com.JV2.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JV2.sistema.entity.User;

// Repositório responsável por operações de banco de dados para a entidade User.

public interface UserRepository extends JpaRepository<User, Long> {

    // Busca usuário pelo email para autenticação

    User findByEmail(String email);
}
