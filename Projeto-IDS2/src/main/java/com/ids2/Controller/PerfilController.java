package com.ids2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    // futuramente pega o usuário da sessão
    @GetMapping("/perfil")
    public String perfil(Model model) {

        // TESTE: apenas mockado
        model.addAttribute("nome", "Usuário Teste");
        model.addAttribute("email", "teste@teste.com");

        return "perfil";
    }
}
