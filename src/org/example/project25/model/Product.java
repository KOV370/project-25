package org.example.project25.model;
import java.math.BigDecimal;

public class Product {
    private String goodsName;
    private String goodsCode;
    private BigDecimal goodsPrice;

    public void setGoodsName(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setGoodsCode(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return goodsCode + '\\' + goodsName + '\\' + goodsPrice +"*";
    }

    public Product(String goodsCode, String goodsName, BigDecimal goodsPrice) {
        this.goodsCode = goodsCode;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }
    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

}
