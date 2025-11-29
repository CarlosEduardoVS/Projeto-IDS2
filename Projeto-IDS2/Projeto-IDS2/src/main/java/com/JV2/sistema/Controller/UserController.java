package com.JV2.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JV2.sistema.model.User;
import com.JV2.sistema.service.UserService;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    // lista usuários
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", userService.findAll());
        return "usuarios/listar"; // pagina thymeleaf
    }

    // abre formulário
    @GetMapping("/novo")
    public String novoUsuario(Model model) {
        model.addAttribute("usuario", new User());
        return "usuarios/form";
    }

    // salva usuário
    @PostMapping
    public String salvarUsuario(User user) {
        userService.save(user);
        return "redirect:/usuarios";
    }

    // edita usuário
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", userService.findById(id));
        return "usuarios/form";
    }

    // remove
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/usuarios";
    }
}
