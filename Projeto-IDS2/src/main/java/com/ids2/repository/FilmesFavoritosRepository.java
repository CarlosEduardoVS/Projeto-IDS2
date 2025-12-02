package com.ids2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ids2.model.FilmesFavoritos;

public interface FilmesFavoritosRepository extends JpaRepository<FilmesFavoritos, Long> {
}
