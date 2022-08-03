package com.tienda.market.domain.repository;

import com.tienda.market.domain.Client;
import com.tienda.market.domain.Purchase;
import com.tienda.market.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    // Obtener lista compras
    Client login(Cliente usuario);
    Client save(Cliente usuario);
}
