package com.tienda.market.domain.service;

import com.tienda.market.domain.Pedido;
import com.tienda.market.domain.Product;
import com.tienda.market.domain.Purchase;
import com.tienda.market.domain.PurchaseItem;
import com.tienda.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private ProductService productService;
    @Autowired
    PurchaseRepository purchaseRepository;

    // Obtener todas las compras.
    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }
    // Obtener las compras realizadas por un cliente.
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }
    // Guardar compra.
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase order(Pedido pedido) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(0);
        purchase.setClientId(pedido.getUsuario().getId()+"");
        List<PurchaseItem>lista = new ArrayList<>();
        for (Product product: pedido.getProductos()) {
            PurchaseItem item = new PurchaseItem();
            item.setActive(true);
            item.setTotal(product.getPrice() * product.getCantidad());
            item.setQuantity(product.getCantidad());
            item.setProductId(product.getProductId());
            lista.add(item);
        }
        purchase.setItems(lista);
        purchase.setComment("Pedido en camino");
        purchase.setPaymentMethod("T");
        purchase.setDate(LocalDateTime.now());
        purchase.setState("1");
        Purchase res = purchaseRepository.save(purchase);
        if(res != null){
            for (Product product: pedido.getProductos()) {
                Product productAux = productService.getProduct(product.getProductId()).get();
                productAux.setStock(productAux.getStock() - product.getCantidad());
                productService.save(productAux);
            }
        }

        return res;
    }
}
