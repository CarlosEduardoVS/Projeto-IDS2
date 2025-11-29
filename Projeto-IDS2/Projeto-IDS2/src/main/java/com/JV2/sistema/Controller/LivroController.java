package com.JV2.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.JV2.sistema.model.Livro;
import com.JV2.sistema.service.LivroService;
import com.JV2.sistema.service.UserService;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private UserService userService; // para listar usuários no form

    // lista todos os livros
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livroService.findAll());
        return "livros/listar";
    }

    // abre formulário
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("usuarios", userService.findAll()); // escolher o usuário
        return "livros/form";
    }

    // salva livro
    @PostMapping
    public String salvar(Livro livro) {
        livroService.save(livro);
        return "redirect:/livros";
    }

    // editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("livro", livroService.findById(id));
        model.addAttribute("usuarios", userService.findAll());
        return "livros/form";
    }

    // deletar
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        livroService.delete(id);
        return "redirect:/livros";
    }
}
