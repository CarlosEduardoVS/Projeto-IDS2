package com.ids2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ids2.model.FilmesFavoritos;
import com.ids2.service.FilmesFavoritosService;

@Controller
@RequestMapping("/filmes")
public class FilmesController {

    private final FilmesFavoritosService filmesService;

    public FilmesController(FilmesFavoritosService filmesService) {
        this.filmesService = filmesService;
    }

    // lista filmes (página filmes.html)
    @GetMapping
    public String listarFilmes(Model model) {

        // filmes mockados só pra teste
        model.addAttribute("filmes", new String[] {
                "Carros 1",
                "Velozes e Furiosos",
                "Star Wars",
                "Matrix"
        });

        return "filmes";
    }

    // favoritar um filme (salva no banco)
    @PostMapping("/favoritar")
    public String favoritarFilme(
            @RequestParam String nome,
            @RequestParam String descricao,
            @RequestParam Double nota,
            @RequestParam String comentario) {

        FilmesFavoritos filme = new FilmesFavoritos();
        filme.setNome(nome);
        filme.setDescricao(descricao);
        filme.setNota(nota);
        filme.setComentario(comentario);

        filmesService.salvar(filme);

        return "redirect:/filmes";
    }
}
