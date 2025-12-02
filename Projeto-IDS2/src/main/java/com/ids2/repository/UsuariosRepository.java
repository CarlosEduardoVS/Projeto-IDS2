package com.ids2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids2.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    // encontra usuário pelo e-mail (usado no login mais pra frente)
    Usuarios findByEmail(String email);
}
