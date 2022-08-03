package com.tienda.market.domain.repository;

import com.tienda.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    // Obtener lista compras
    List<Purchase> getAll();
    // Obtener lista compras de un cliente. Optional es para controlar si un cliente no tiene compra.
    Optional<List<Purchase>> getByClient(String client);
    // Guardar una compra.
    Purchase save(Purchase purchase);
}
