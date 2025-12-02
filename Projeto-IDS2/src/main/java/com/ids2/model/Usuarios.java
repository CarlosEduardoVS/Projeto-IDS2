package com.ids2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data           // getters, setters, equals, hashcode, toString
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String nome;

    private Integer idade;
}
