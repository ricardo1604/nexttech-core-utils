package com.nexttech.utils.nexttech_core_utils.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexttech.utils.nexttech_core_utils.entities.Usuario;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    //metodo post para hacer login
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        System.out.println("El usuario recibido: " + usuario.getNombre());

        return usuario.getNombre() + " ha iniciado sesion!";
    }

    @GetMapping("/keepalive")
    public String keepAlive() {
       return "Estoy vivo!";
    }
}
