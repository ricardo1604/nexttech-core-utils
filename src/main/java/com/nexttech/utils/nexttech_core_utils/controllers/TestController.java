package com.nexttech.utils.nexttech_core_utils.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexttech.utils.nexttech_core_utils.repo.RepositorioJpa;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private RepositorioJpa repo;

    @GetMapping("/testconn")
    public String test() {
        return "Conexión a PostgreSQL exitosa!";
    }
}
