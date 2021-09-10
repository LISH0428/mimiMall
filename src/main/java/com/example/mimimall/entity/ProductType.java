package com.example.mimimall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="商品类型", description="")
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("商品id")
      @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;
    @ApiModelProperty("类型名称")
    private String typeName;


}
