package com.example.mimimall.vo;

import io.swagger.models.auth.In;

public class ProductInfoVo {
    //名称
    private String pName;
    // 类型
    private String typeId;
    // min
    private String minPrice;
    // max
    private String maxPrice;

    @Override
    public String toString() {
        return "ProductInfoVo{" +
                "pName='" + pName + '\'' +
                ", typeId=" + typeId +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }
}
