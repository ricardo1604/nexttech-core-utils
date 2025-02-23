package com.nexttech.utils.nexttech_core_utils.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexttech.utils.nexttech_core_utils.model.User;
import com.nexttech.utils.nexttech_core_utils.service.AuthService;
import com.nexttech.utils.nexttech_core_utils.service.UsuarioService;

@RestController
@RequestMapping("/auth/api/")
public class AuthController {

    @Autowired
    private AuthService authService;
    private UsuarioService usuarioService;

    //metodo post para hacer login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credenciales) {
        System.out.println("Iniciando Login!!!!");
        String usuario = credenciales.get("username");
        String password = credenciales.get("password");

        if (authService.autenticar(usuario, password)) {
            return ResponseEntity.ok("Login Exitoso!");
        } else {
            return ResponseEntity.status(401).body("Credenciales Invalidas");
        }
    }

    //Registrar usuario
    /* 
    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Map<String, String> credenciales) {
        System.out.println("Registrando Usuario");
        String usuario = credenciales.get("username");
        String password = credenciales.get("password");
        String rol = credenciales.get("rol");

        User user = new User();

        user.setPassw(password);
        user.setUsuario(usuario);
        user.setRol(Integer.parseInt(rol));

        usuarioService.registrarUsuario(user);

        return ResponseEntity.ok("Usuario registrado con Exitoso!");

    } */
    
}
