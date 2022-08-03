package com.tienda.market.persistence.crud;

import com.tienda.market.persistence.entity.Categoria;
import com.tienda.market.persistence.entity.Compra;
import com.tienda.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {
    // Query Method
    List<Categoria> findAll();
}
