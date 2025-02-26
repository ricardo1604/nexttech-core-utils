package com.nexttech.utils.nexttech_core_utils.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nexttech.utils.nexttech_core_utils.model.User;
import com.nexttech.utils.nexttech_core_utils.repository.UserRepositorio;

@Service
public class UsuarioService {

    @Autowired
    private UserRepositorio userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //private BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();

    public User registrarUsuario(User usuario) {
        //usuario.setPassw(passwordEnconder.encode(usuario.getPassw()));
        if (userRepo.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Email ya esta en uso.");
        }
        usuario.setPassw(passwordEncoder.encode(usuario.getPassw()));
        //Guardar
        return userRepo.save(usuario);
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }
}
