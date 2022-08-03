package com.tienda.market.domain.service;

import com.tienda.market.domain.Client;
import com.tienda.market.persistence.UsuarioRepository;
import com.tienda.market.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public Client login(Usuario usuario) {

        return repository.login(usuario);
    }

    public Client save(Usuario usuario) {

        return repository.save(usuario);
    }
}
