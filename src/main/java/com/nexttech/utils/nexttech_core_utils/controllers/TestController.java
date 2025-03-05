package com.nexttech.utils.nexttech_core_utils.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexttech.utils.nexttech_core_utils.repository.UserRepositorio;

@RestController
@RequestMapping("/api")
public class TestController {

    private UserRepositorio repo;

    public TestController(UserRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping("/testconn")
    public String test() {
        return "Conexión a PostgreSQL exitosa!";
    }

    @GetMapping("/keepalive")
    public String keepAlive() {
       return "Estoy vivo!";
    }
}
