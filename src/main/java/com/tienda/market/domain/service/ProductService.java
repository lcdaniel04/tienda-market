package com.tienda.market.domain.service;

import com.tienda.market.domain.Product;
import com.tienda.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import  java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Obtener todos los productos
    public List<Product> getAll() {
        return  productRepository.getAll();
    }

    // Obtener un producto por id
    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    // Consultar productos por id Categoria
    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    // Guardar producto
    public Product save(Product product) {
        return  productRepository.save(product);
    }

    // Eliminar un producto por id
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return  true;
        }).orElse(false);

        // Otra forma de hacer delete
        /*if(getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }*/
    }
}
