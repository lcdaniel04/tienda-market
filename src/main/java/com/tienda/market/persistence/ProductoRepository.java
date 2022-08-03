package com.tienda.market.persistence;

import com.tienda.market.domain.Product;
import com.tienda.market.domain.repository.ProductRepository;
import com.tienda.market.persistence.crud.ProductoCrudRepository;
import com.tienda.market.persistence.entity.Producto;
import com.tienda.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return  mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
         return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    /*public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }*/

    /*public Optional<List<Producto>> getEscasos(int cantidad) {
        return  productoCrudRepository.findByCantidadStockLessThanAndEidstado(cantad, true);
    }*/

    /*public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }*/

    // Guardar producto.
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    // Borrar un producto.
    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}