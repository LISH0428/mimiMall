package com.example.mimimall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = false)
@ApiModel(value="管理员账号", description="")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
      @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPass() {
        return aPass;
    }

    public void setaPass(String aPass) {
        this.aPass = aPass;
    }
    @ApiModelProperty("用户名")
    private String aName;
    @ApiModelProperty("密码")
    private String aPass;


}
