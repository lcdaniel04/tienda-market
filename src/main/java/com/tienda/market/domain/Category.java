package com.tienda.market.domain;

import com.tienda.market.persistence.entity.Producto;

import javax.persistence.OneToMany;
import java.util.List;

public class Category {
    private int categoryId;
    private String category;
    private boolean active;

    private List<Producto> products;
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Producto> getProducts() {
        return products;
    }

    public void setProducts(List<Producto> products) {
        this.products = products;
    }
}
