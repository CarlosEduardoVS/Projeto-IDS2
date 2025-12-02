package com.ids2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ids2.model.FilmesFavoritos;
import com.ids2.repository.FilmesFavoritosRepository;

@Service
public class FilmesFavoritosService {

    private final FilmesFavoritosRepository filmesRepository;

    public FilmesFavoritosService(FilmesFavoritosRepository filmesRepository) {
        this.filmesRepository = filmesRepository;
    }

    // lista todos os filmes favoritados
    public List<FilmesFavoritos> listarTodos() {
        return filmesRepository.findAll();
    }

    // salva filme favorito
    public FilmesFavoritos salvar(FilmesFavoritos filme) {
        return filmesRepository.save(filme);
    }

    // busca por id
    public FilmesFavoritos buscarPorId(Long id) {
        return filmesRepository.findById(id).orElse(null);
    }

    // remove filme favorito
    public void deletar(Long id) {
        filmesRepository.deleteById(id);
    }
}
