package com.tienda.market.persistence;


import com.tienda.market.domain.Client;
import com.tienda.market.persistence.crud.ProductoCrudRepository;
import com.tienda.market.persistence.crud.UsuarioCrudRepository;
import com.tienda.market.persistence.entity.Cliente;
import com.tienda.market.persistence.mapper.ClienteMapper;
import com.tienda.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tienda.market.persistence.entity.Cliente;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements com.tienda.market.domain.repository.UsuarioRepository {
    @Autowired
    private UsuarioCrudRepository repositorio;
    @Autowired
    private ClienteMapper mapper;
    @Override
    public Client login(Cliente usuario) {
        Cliente res = repositorio.findByUserPassword(usuario.getEmail(),usuario.getPassword());
        return  mapper.toClient(res);
    }
    @Override
    public Client save(Cliente usuario) {
        Cliente res = repositorio.save(usuario);
        return  mapper.toClient(res);
    }
}