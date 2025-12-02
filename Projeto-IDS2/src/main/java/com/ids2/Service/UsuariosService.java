package com.ids2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ids2.model.Usuarios;
import com.ids2.repository.UsuariosRepository;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // retorna todos usuários
    public List<Usuarios> listarTodos() {
        return usuariosRepository.findAll();
    }

    // salva ou atualiza usuário
    public Usuarios salvar(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    // busca usuário por ID
    public Usuarios buscarPorId(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    // deleta usuário por ID
    public void deletar(Long id) {
        usuariosRepository.deleteById(id);
    }
}
