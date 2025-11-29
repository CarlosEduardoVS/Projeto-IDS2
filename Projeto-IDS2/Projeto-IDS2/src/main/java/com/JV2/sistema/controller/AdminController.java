package com.JV2.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;


// Controlador responsável pelas telas e ações do ADMIN

@Controller
@RequiredArgsConstructor
public class AdminController {

    //Página inicial do painel administrativo

    @GetMapping("/admin/home")
    public String homeAdmin() {
        return "admin/home"; // templates/admin/home.html
    }

    //  * Tela inicial de gerenciamento de usuários.

    @GetMapping("/admin/users")
    public String gerenciarUsuarios() {
        return "admin/users"; // templates/admin/users.html
    }

    //  * Tela inicial de gerenciamento de livros.

    @GetMapping("/admin/books")
    public String gerenciarLivros() {
        return "admin/books"; // templates/admin/books.html
    }
}
