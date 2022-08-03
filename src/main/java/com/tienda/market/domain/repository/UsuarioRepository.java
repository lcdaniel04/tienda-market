package com.tienda.market.domain.repository;

import com.tienda.market.domain.Client;
import com.tienda.market.persistence.entity.Usuario;

public interface UsuarioRepository {
    // Obtener lista compras
    Client login(Usuario usuario);
    Client save(Usuario usuario);
}
