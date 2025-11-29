package com.JV2.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JV2.sistema.model.User;
import com.JV2.sistema.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // cria usuário
    public User save(User user) {
        return userRepository.save(user);
    }

    // lista todos
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // busca por id
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null); // retorna null se não achar
    }

    // remove
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
