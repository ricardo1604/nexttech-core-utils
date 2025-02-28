package com.nexttech.utils.nexttech_core_utils.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexttech.utils.nexttech_core_utils.service.AuthService;
import com.nexttech.utils.nexttech_core_utils.service.CustomUserDetailsService;
import com.nexttech.utils.nexttech_core_utils.service.JwtUtil;

@RestController
@RequestMapping("/auth/api/")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    //metodo post para hacer login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credenciales) {
        System.out.println("Iniciando Login!!!!");
        String usuario = credenciales.get("usuario");
        String password = credenciales.get("passw");

        if (authService.autenticar(usuario, password)) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
            UserDetails userDetails = userDetailsService.loadUserByUsername(usuario);

            return ResponseEntity.ok(jwtUtil.generateToken(userDetails.getUsername()));
        } else {
            return ResponseEntity.status(401).body("Credenciales Invalidas");
        }
    }
    
}
