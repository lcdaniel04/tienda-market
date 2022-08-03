package com.tienda.market.web.controller;


import com.tienda.market.domain.Client;
import com.tienda.market.domain.service.UsuarioService;
import com.tienda.market.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService service;


    @PostMapping(value="/login",consumes = "application/json")
    public ResponseEntity<Client> login(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(service.login(usuario), HttpStatus.CREATED);
    }

    @PostMapping(value="/singIn",consumes = "application/json")
    public ResponseEntity<Client> save(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(service.save(usuario), HttpStatus.CREATED);
    }
}
