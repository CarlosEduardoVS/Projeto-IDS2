package com.JV2.sistema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity                     // indica que essa classe é uma tabela no banco
@Table(name = "usuarios")   // nome da tabela
@Data                       // Lombok - gera getters/setters/equals/hashcode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // chave primária

    private boolean ativo;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    private String role;

    @NotBlank
    private String senha;

    @NotBlank
    private String cep;

    @NotBlank
    private String endereco;

    private String complemento;
}
