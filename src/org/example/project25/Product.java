package org.example.project25;

public class Product {
    private String goodsName;
    private String goodsCode;
    private double goodsPrice;


    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }


    @Override
    public String toString() {
        return goodsName + '\\' + goodsCode + '\\' + goodsPrice + '\\';
    }

    public Product(String goodsName, String goodsCode, String goodsPrice) {
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
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
