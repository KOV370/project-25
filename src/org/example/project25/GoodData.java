package org.example.project25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GoodData {

    static ArrayList<Good> goodData() {
        ArrayList<Good> goodList = new ArrayList<>();
        goodList.add(new Good("good4", "code4", "453.44"));
        goodList.add(new Good("good2", "code2", "34.22"));
        goodList.add(new Good("good1", "code1", "8900.11"));
        goodList.add(new Good("good3", "code3", "3346.33"));
        return goodList;
    }

    public static Good addNewGoods() throws IOException {
    //    ArrayList<Good> arrayForNewGoods = new ArrayList<>();
        BufferedReader readNewGoods = new BufferedReader(new InputStreamReader(System.in));
        Good good = null;
        System.out.println("Enter goodsName");
        String newGoodsName = readNewGoods.readLine();
        System.out.println("Enter goodsCode");
        String newGoodsCode = readNewGoods.readLine();
        System.out.println("Enter goodsPrice");
        String newGoodsPrice = readNewGoods.readLine(); //как ввести цифры double
        good = new Good(newGoodsName, newGoodsCode, newGoodsPrice);
        return good;
    }

}

