package com.tienda.market.domain.service;

import com.tienda.market.domain.Category;
import com.tienda.market.persistence.CategoriaRepository;
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
