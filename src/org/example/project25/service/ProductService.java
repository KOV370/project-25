package org.example.project25.service;

import org.example.project25.model.Product;
import org.example.project25.repository.ProductRepository;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static ArrayList<Product> initializeProductsData() {//todo remove static
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("4", "rgvvvvvc", new BigDecimal(453.44).setScale(2, RoundingMode.HALF_UP)));
        products.add(new Product("2", "efogfo,k", new BigDecimal(34.22).setScale(2, RoundingMode.HALF_UP)));
        products.add(new Product("1", ",xf.px.x", new BigDecimal(8900.11).setScale(2, RoundingMode.HALF_UP)));
        products.add(new Product("3", "rqerc", new BigDecimal(3346.33).setScale(2, RoundingMode.HALF_UP)));
        System.out.println("List of goods added successfully");
        return products;
    }

    public static Product addNewGoods() {
        boolean correctPrice = true;//todo remove
        BufferedReader readNewGoods = new BufferedReader(new InputStreamReader(System.in));
        Product good;
        correctPrice = true;//сброс указателя в начальное состояние
        System.out.println("Enter goodsCode");
        String newGoodsCode = null;
        try {
            newGoodsCode = readNewGoods.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter newGoodsName");
        String newGoodsName = null;
        try {
            newGoodsName = readNewGoods.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter goodsPrice");
        BigDecimal newGoodsPrice = null;
        try {
            newGoodsPrice = new BigDecimal(readNewGoods.readLine());
        } catch (NumberFormatException r) {
            System.out.println("It is not a figures, try enter goodsPrice again.");
            try {
                newGoodsPrice = new BigDecimal(readNewGoods.readLine()); //вторая попытка вводо цены
            } catch (NumberFormatException y) {
                correctPrice = false;
                System.out.println("It is second mistake, try new product.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!correctPrice) {
            System.out.println("Enter new product again.");
            good = null;
        } else
            good = new Product(newGoodsCode, newGoodsName, newGoodsPrice);
        return good;
    }

    public List<Product> listAllProducts() {
        return productRepository.readAllProducts();
    }
}

