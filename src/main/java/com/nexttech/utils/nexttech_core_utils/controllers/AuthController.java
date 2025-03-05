package com.nexttech.utils.nexttech_core_utils.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexttech.utils.nexttech_core_utils.dto.LoginResponse;
import com.nexttech.utils.nexttech_core_utils.dto.TokenValidationResponse;
import com.nexttech.utils.nexttech_core_utils.service.AuthService;
import com.nexttech.utils.nexttech_core_utils.service.JwtUtil;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth/api/")
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;


    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    //metodo post para hacer login
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> credenciales) {
        log.info("Iniciando Login!!!!");
        String usuario = credenciales.get("usuario");
        String password = credenciales.get("passw");

        
        if (authService.autenticar(usuario, password)) {
            String token = jwtUtil.generateToken(usuario);
            LoginResponse loginResponse = new LoginResponse(token,
             usuario, "1", jwtUtil.extractExpiration(token).getTime(), "");

            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(401).body(new LoginResponse("", "", "", 0, "Credenciales Invalidas"));
        }
    }
    
    @GetMapping("/validate")
    public ResponseEntity<TokenValidationResponse> validateToken(@RequestParam String token) {
        log.info(token);
        String usr = jwtUtil.extractUsername(token);

        TokenValidationResponse tvr = 
            new TokenValidationResponse(jwtUtil.validateToken(token, usr), usr);

        return ResponseEntity.ok(tvr);
    }
    
}
