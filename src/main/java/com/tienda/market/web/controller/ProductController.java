package com.tienda.market.web.controller;

import com.tienda.market.domain.Category;
import com.tienda.market.domain.Product;
import com.tienda.market.domain.service.CategoryService;
import com.tienda.market.domain.service.ProductService;
import com.tienda.market.persistence.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Controlador de una API Rest
@RequestMapping("/product") //Parametro para aceptar peticiones realizadas.
@CrossOrigin
public class ProductController {

    // Inyectar el servicio
    // Nota: Usamos @Autowired porque ProductService tiene una anotación de spring.
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    // Obtener lista de todos los productos.
    @GetMapping("/all") // Exponer o publicar servicio
    /*public List<Product> getAll() {
        return  productService.getAll();
    }*/
    public ResponseEntity<List<Product>> getAll() {
        return  new ResponseEntity<> (productService.getAll(), HttpStatus.OK);
    }

    // Obtener producto por id
    @GetMapping("/{id}") // se invocar por variable
    /*public Optional<Product> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId);
    }*/
    public ResponseEntity <Product> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener Productos por id categoria
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return  productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Guardar un objeto produto
    @PostMapping("/save")
    /*public Product save(@RequestBody Product product) {
        return productService.save(product);
    }*/
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    // Eliminar producto
    @DeleteMapping("/delete/{id}")
    /*public boolean delete(@PathVariable("id") int productId) {
        return productService.delete(productId);
    }*/
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if(productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    // Obtener Productos por id categoria
    @GetMapping("/categorys")
    /*public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return  productService.getByCategory(categoryId);
    }*/
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.all(), HttpStatus.OK);
    }
}
