package org.example.project25.model;

import org.example.project25.model.Product;

public class BasketProduct {
    private Product product;
    private int quantity;

    public BasketProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
