package com.nexttech.utils.nexttech_core_utils.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nexttech.utils.nexttech_core_utils.model.User;
import com.nexttech.utils.nexttech_core_utils.repository.UserRepositorio;

@Service
public class AuthService {

    @Autowired
    private UserRepositorio userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean autenticar(String user, String password) {
        System.out.println(user);
        Optional<User> userOptional = userRepo.findByUsuario(user);
        System.out.println(userOptional);
        if (userOptional.isPresent()) {
            User usuario = userOptional.get();
            return passwordEncoder.matches(password, usuario.getPassw());
            //return usuario.getPassw().equals(password);
        }
        return false;
    }

}
