package com.JV2.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JV2.sistema.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
