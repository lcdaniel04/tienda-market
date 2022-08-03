package com.tienda.market.domain.service;

import com.tienda.market.domain.Category;
import com.tienda.market.domain.Client;
import com.tienda.market.persistence.CategoriaRepository;
import com.tienda.market.persistence.UsuarioRepository;
import com.tienda.market.persistence.entity.Categoria;
import com.tienda.market.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoriaRepository repository;

    public List<Category> all() {
        return repository.all();
    }
}
