package com.nexttech.utils.nexttech_core_utils.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nexttech.utils.nexttech_core_utils.model.User;
import com.nexttech.utils.nexttech_core_utils.repository.UserRepositorio;

@Service
public class AuthService {

    @Autowired
    private UserRepositorio userRepo;

    //private BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();

    public boolean autenticar(String user, String password) {
        Optional<User> userOptional = userRepo.findByUsuario(user);
        if (userOptional.isPresent()) {
            User usuario = userOptional.get();
            //return passwordEnconder.matches(password, usuario.getPassw());
            return usuario.getPassw().equals(password);
        }
        return false;
    }

}
