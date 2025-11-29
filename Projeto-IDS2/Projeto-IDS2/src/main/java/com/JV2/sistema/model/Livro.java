package com.JV2.sistema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "livros")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // relacionamento: muitos livros para 1 usuário
    @ManyToOne
    @JoinColumn(name = "idusuario") // chave estrangeira
    private User usuario;

    @NotBlank
    private String nomeLivro;

    @NotBlank
    private String categoria;

}
