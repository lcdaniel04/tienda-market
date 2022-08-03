package com.tienda.market.domain;

import java.time.LocalDateTime;
import java.util.List;

// Compra
public class Pedido {
    private Client usuario;
    private List<Product> productos;

    private Double total;

    public Pedido(Client usuario, List<Product> productos) {
        this.usuario = usuario;
        this.productos = productos;
    }

    public Client getUsuario() {
        return usuario;
    }

    public void setUsuario(Client usuario) {
        this.usuario = usuario;
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
