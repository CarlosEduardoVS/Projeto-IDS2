package com.JV2.sistema.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.JV2.sistema.entity.User;
import com.JV2.sistema.repository.UserRepository;

import lombok.RequiredArgsConstructor;


// Serviço responsável pelas regras de negócio

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    
    // Realiza o cadastro de um novo usuário
    // A senha é criptografada antes de salvar
    
    public User cadastrar(User user) {
        user.setSenha(encoder.encode(user.getSenha()));
        user.setRole(User.Role.USER); // padrão é usuário comum
        return repository.save(user);
    }

    // Busca um usuário pelo email
    
    public User buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}
