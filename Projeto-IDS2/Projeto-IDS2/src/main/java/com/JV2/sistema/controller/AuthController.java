package com.JV2.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.JV2.sistema.entity.User;
import com.JV2.sistema.service.UserService;

import lombok.RequiredArgsConstructor;

// Controlador responsável por lidar com login e cadastro

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    // Exibe o formulário de login

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Exibe o formulário de cadastro

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Recebe o cadastro do usuário

    @PostMapping("/register")
    public String cadastrar(@ModelAttribute User user) {
        userService.cadastrar(user);
        return "redirect:/login";
    }


    // Redireciona o usuário logado para o dashboard correto baseado no seu papel (ADMIN ou USER).

    @GetMapping("/redirect")
    public String redirecionarPorRole() {

        var username = org.springframework.security.core.context.SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        var user = userService.buscarPorEmail(username);

        if (user.getRole() == User.Role.ADMIN) {
            return "redirect:/admin/dashboard";
        }

        return "redirect:/user/dashboard";
    }
}
