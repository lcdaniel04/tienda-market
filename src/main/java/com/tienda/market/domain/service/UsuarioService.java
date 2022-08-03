package com.tienda.market.domain.service;

import com.tienda.market.domain.Client;
import com.tienda.market.persistence.UsuarioRepository;
import com.tienda.market.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public Client login(Cliente usuario) {

        return repository.login(usuario);
    }

    public Client save(Cliente usuario) {

        return repository.save(usuario);
    }
}
