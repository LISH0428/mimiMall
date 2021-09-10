package com.example.mimimall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;



@EqualsAndHashCode(callSuper = false)
@ApiModel(value="商品信息", description="123")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("商品id")
      @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;
    @ApiModelProperty("商品名")
    private String pName;
    @ApiModelProperty("商品信息")
    private String pContent;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pContent='" + pContent + '\'' +
                ", pPrice=" + pPrice +
                ", pImage='" + pImage + '\'' +
                ", pNumber=" + pNumber +
                ", typeId=" + typeId +
                ", pDate=" + pDate +
                '}';
    }
    @ApiModelProperty("价格")
    private Integer pPrice;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public Integer getpPrice() {
        return pPrice;
    }

    public void setpPrice(Integer pPrice) {
        this.pPrice = pPrice;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }
    @ApiModelProperty("图片")
    private String pImage;
    @ApiModelProperty("数量")
    private Integer pNumber;
    @ApiModelProperty("类型")
    private Integer typeId;
    @ApiModelProperty("创建日期")
    private Date pDate;


    public ProductInfo() {
    }
}
