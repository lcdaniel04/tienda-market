package com.tienda.market.persistence;


import com.tienda.market.domain.Category;
import com.tienda.market.domain.repository.CategoryRepository;
import com.tienda.market.persistence.crud.CategoriaCrudRepository;
import com.tienda.market.persistence.entity.Categoria;
import com.tienda.market.persistence.entity.Cliente;
import com.tienda.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepository implements CategoryRepository {
    @Autowired
    private CategoriaCrudRepository repositorio;
    @Autowired
    private CategoryMapper mapper;
    @Override
    public List<Category> all() {
        List<Category> categorias = new ArrayList<>();
        repositorio.findAll().forEach(
                categoria -> {
                    categorias.add(mapper.toCategory(categoria));
                }
                );
        return categorias;
    }
}