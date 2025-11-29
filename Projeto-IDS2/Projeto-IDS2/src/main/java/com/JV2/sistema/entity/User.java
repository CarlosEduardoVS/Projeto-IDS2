package com.JV2.sistema.entity;

import jakarta.persistence.*;
import lombok.*;

// usuários do sistema Possui dois perfis: ADMIN e USER.

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome de exibição do usuário
    private String nome;

    // Email único utilizado no login
    @Column(unique = true, nullable = false)
    private String email;

    // Senha criptografada
    private String senha;

    // Papel do usuário no sistema
    @Enumerated(EnumType.STRING)
    private Role role;

    // Indica se a conta está ativa ou desativada
    private boolean ativo = true;

    // Tipos de usuários aceitos
    public enum Role {
        ADMIN, USER
    }
}
