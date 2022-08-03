package com.tienda.market.domain.repository;

import com.tienda.market.domain.Category;
import com.tienda.market.persistence.entity.Categoria;

import java.util.List;

public interface CategoryRepository {
    // Obtener lista compras
    List<Category> all();
}
