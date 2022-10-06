package org.example.project25;

import java.io.*;
import java.util.ArrayList;

public class GoodData {
    private static String fileListGoogs;

    static ArrayList<Good> goodData() {
        ArrayList<Good> goodList = new ArrayList<>();
        goodList.add(new Good("4", "code4", "453.44"));
        goodList.add(new Good("2", "code2", "34.22"));
        goodList.add(new Good("1", "code1", "8900.11"));
        goodList.add(new Good("3", "code3", "3346.33"));
        System.out.println("List of goods added successfully");
        return goodList;
    }

    public static Good addNewGoods() throws IOException {
        BufferedReader readNewGoods = new BufferedReader(new InputStreamReader(System.in));
        Good good;
        System.out.println("Enter goodsName");
        String newGoodsName = readNewGoods.readLine();
        System.out.println("Enter goodsCode");
        String newGoodsCode = readNewGoods.readLine();
        System.out.println("Enter goodsPrice");
        String newGoodsPrice = readNewGoods.readLine(); //как ввести цифры double
        good = new Good(newGoodsName, newGoodsCode, newGoodsPrice);
        return good;
    }

    private static ArrayList<Good> fillBasket() throws IOException {
        String laneGoods;
        ArrayList<String> goodArrayList = new ArrayList<>();
        BufferedReader enterGoodsName = new BufferedReader(new InputStreamReader(System.in));//чтение названия товара с консоли
        String goodsName = enterGoodsName.readLine();
        BufferedReader readListGoods = new BufferedReader(new FileReader(fileListGoogs));//чтение списка товара из файла
        do {
            laneGoods = readListGoods.readLine();
            int firstBackslash = laneGoods.indexOf("\\");
            String nameInLane = laneGoods.substring(0, firstBackslash + 1);
            if (goodsName.equals(nameInLane)) {
                goodArrayList.add(laneGoods);
                System.out.println("Choose the quantity");
                BufferedReader enterQuantity = new BufferedReader(new InputStreamReader(System.in));
                try {
                    Integer.parseInt(enterQuantity.readLine());
                    goodArrayList.add(laneGoods + enterQuantity.readLine());
                } catch (NumberFormatException t) {
                    System.out.println("Enter right number");
                    continue;
                }
            }
        }
        while (!laneGoods.isEmpty()||laneGoods!=null);
        System.out.println(goodArrayList);
        return goodArrayList;
    }
}

