package com.tienda.market.persistence;


import com.tienda.market.domain.Client;
import com.tienda.market.persistence.crud.UsuarioCrudRepository;
import com.tienda.market.persistence.entity.Usuario;
import com.tienda.market.persistence.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements com.tienda.market.domain.repository.UsuarioRepository {
    @Autowired
    private UsuarioCrudRepository repositorio;
    @Autowired
    private ClienteMapper mapper;
    @Override
    public Client login(Usuario usuario) {
        Usuario res = repositorio.findByUserPassword(usuario.getEmail(),usuario.getPassword());
        return  mapper.toClient(res);
    }
    @Override
    public Client save(Usuario usuario) {
        Usuario res = repositorio.save(usuario);
        return  mapper.toClient(res);
    }
}