package com.nexttech.utils.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexttech.utils.entities.Usuario;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    //metodo post para hacer login
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        System.out.println("El usuario recibido: " + usuario.getNombre());

        return usuario.getNombre() + " ha iniciado sesion!";
    }
}
