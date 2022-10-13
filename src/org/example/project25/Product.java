package org.example.project25;

public class Product {
    private String goodsName;
    private String goodsCode;
    private double goodsPrice;


    public void setGoodsName(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setGoodsCode(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }


    @Override
    public String toString() {
        return goodsCode + '\\' + goodsName + '\\' + goodsPrice +"*";
    }

    public Product(String goodsCode, String goodsName, Double goodsPrice) {
        this.goodsCode = goodsCode;
        this.goodsName = goodsName;
        this.goodsPrice = Double.parseDouble(String.valueOf(goodsPrice));
    }
    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

}
