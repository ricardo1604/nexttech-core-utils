package com.nexttech.utils.nexttech_core_utils.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nexttech.utils.nexttech_core_utils.model.User;
import com.nexttech.utils.nexttech_core_utils.repository.UserRepositorio;

@Service
public class UsuarioService {

    @Autowired
    private UserRepositorio userRepo;

    //private BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();

    public void registrarUsuario(User usuario) {
        //usuario.setPassw(passwordEnconder.encode(usuario.getPassw()));
        userRepo.save(usuario);
    }
}
