package org.example.project25;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {


    static ArrayList<Product> goodData() {
        ArrayList<Product> goodList = new ArrayList<>();
        goodList.add(new Product("4", "rgvvvvvc", 453.44));
        goodList.add(new Product("2", "efogfo,k", 34.22));
        goodList.add(new Product("1", ",xf.px.x", 8900.11));
        goodList.add(new Product("3", "rqerc", 3346.33));
        System.out.println("List of goods added successfully");
        return goodList;
    }

    public static Product addNewGoods() {
        BufferedReader readNewGoods = new BufferedReader(new InputStreamReader(System.in));
        Product good;
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
        Double newGoodsPrice = null; //как ввести цифры double
        try {
            newGoodsPrice = Double.valueOf(readNewGoods.readLine());
        } catch (NumberFormatException r) {
            System.out.println("It is not a figures, try enter goodsPrice again.");//todo как при неправильном вводе вернуться к вводу цены, а не вводу нового товара?
            try {
                newGoodsPrice = Double.valueOf(readNewGoods.readLine()); //вторая попытка вводо цены
            }catch (NumberFormatException y){
                System.out.println("It is second mistake, try new product.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        good = new Product(newGoodsCode, newGoodsName, newGoodsPrice);
        return good;
    }
}

