package org.example.project25.repository;

import org.example.project25.model.Product;

import java.util.List;

abstract public class ProductRepository {
    abstract public List<Product> readAllProducts();
    abstract public Product getByCode(String code);

}
