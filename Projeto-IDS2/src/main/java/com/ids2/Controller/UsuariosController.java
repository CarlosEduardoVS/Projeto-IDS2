package com.ids2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ids2.model.Role;
import com.ids2.model.Usuarios;
import com.ids2.service.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // lista todos os usuários (adminUsuarios.html)
    @GetMapping("/admin")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuariosService.listarTodos());
        return "adminUsuarios";
    }

    // abre formulário de edição/criação (adminUsuariosForm.html)
    @GetMapping("/form")
    public String formUsuario(@RequestParam(required = false) Long id, Model model) {

        // se veio ID, carrega o usuário para edição
        if (id != null) {
            model.addAttribute("usuario", usuariosService.buscarPorId(id));
        } else {
            model.addAttribute("usuario", new Usuarios());
        }

        model.addAttribute("roles", Role.values());
        return "adminUsuariosForm";
    }

    // salva usuário
    @PostMapping("/salvar")
    public String salvarUsuario(Usuarios usuario) {
        usuariosService.salvar(usuario);
        return "redirect:/usuarios/admin";
    }

    // deleta usuário
    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuariosService.deletar(id);
        return "redirect:/usuarios/admin";
    }
}
