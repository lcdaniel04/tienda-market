package com.tienda.market.persistence.crud;

import com.tienda.market.domain.Purchase;
import com.tienda.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    // Query Method
    Optional<List<Compra>> findByIdCliente(String idCliente);


}
