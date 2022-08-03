package com.tienda.market.persistence;

import com.tienda.market.domain.Purchase;
import com.tienda.market.domain.repository.PurchaseRepository;
import com.tienda.market.persistence.crud.CompraCrudRepository;
import com.tienda.market.persistence.entity.Compra;
import com.tienda.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Sirve para indicarle a spring que es un componente/bean y que va comunicarse con la BD.
public class CompraRepository implements PurchaseRepository {
    // Inyección CompraCrudRepository con @Autowired
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    // Inyectar purcharseMapper para hablar en terminos del dominio.
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        // Convertir Purchase a Compra por medio del mapper.
        Compra compra = mapper.toCompra(purchase);
        // Guardar productos en cascada
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchse(compraCrudRepository.save(compra));
    }
}
