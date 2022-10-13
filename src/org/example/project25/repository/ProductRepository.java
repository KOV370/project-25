package org.example.project25.repository;

import org.example.project25.Product;

import java.util.List;

abstract public class ProductRepository {
    abstract public List<Product> listProducts();
    abstract public Product getByCode(String code);

}
