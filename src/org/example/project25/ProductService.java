package org.example.project25;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {


    static ArrayList<Product> goodData() {
        ArrayList<Product> goodList = new ArrayList<>();
        goodList.add(new Product("4", "code4", "453.44"));
        goodList.add(new Product("2", "code2", "34.22"));
        goodList.add(new Product("1", "code1", "8900.11"));
        goodList.add(new Product("3", "code3", "3346.33"));
        System.out.println("List of goods added successfully");
        return goodList;
    }

    public static Product addNewGoods() throws IOException {
        BufferedReader readNewGoods = new BufferedReader(new InputStreamReader(System.in));
        Product good;
        System.out.println("Enter goodsName");
        String newGoodsName = readNewGoods.readLine();
        System.out.println("Enter goodsCode");
        String newGoodsCode = readNewGoods.readLine();
        System.out.println("Enter goodsPrice");
        String newGoodsPrice = readNewGoods.readLine(); //как ввести цифры double
        good = new Product(newGoodsName, newGoodsCode, newGoodsPrice);
        return good;
    }


}

