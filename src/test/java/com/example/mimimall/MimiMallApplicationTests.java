package com.example.mimimall;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mimimall.entity.ProductInfo;
import com.example.mimimall.entity.ProductType;
import com.example.mimimall.mapper.ProductInfoMapper;
import com.example.mimimall.service.AdminService;
import com.example.mimimall.service.ProductInfoService;
import com.example.mimimall.service.ProductTypeService;
import com.example.mimimall.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MimiMallApplicationTests {
    @Autowired
    AdminService adminService;
    @Autowired
    ProductInfoService productInfoService;
    @Autowired
    ProductInfoMapper productInfoMapper;
    @Autowired
    ProductTypeService ptService;

    @Test
    public String md5(){
        //测试MD5工具类
        return MD5Util.getMD5("000000");

    }
    @Test
    public void test1(){
        //测试登录密码加密功能
        System.out.println(adminService.login("admin","000000"));
    }
    @Test
    public  void test2(){
        //测试查询全部信息
        //List<ProductInfo> list = productInfoService.list();
        List<ProductType> list=ptService.list();
        for(ProductType productType:list){
            System.out.println(productType.toString());
        }
    }
    @Test
    public void test3() {
        //测试分页插件
        Page<ProductInfo> page = new Page<>(1, 5);
        page.addOrder(OrderItem.desc("p_id"));
        productInfoMapper.selectPage(page, null);
        //page.getRecords().forEach(System.out::println);
        System.out.println();
    }
    @Test
    public void test4(){
        String str="11,22,33,44,55";
        String[] split=str.split(",");
        Arrays.asList(split);

       // for(String st:split){
         //   System.out.println(st);
        }

    public void query(String pName,String type,String gt,String lt){
        QueryWrapper<ProductInfo> wrapper=new QueryWrapper();
        wrapper.like(StringUtils.isNotBlank(pName),"p_name",pName)
                .eq(StringUtils.isNotBlank(type),"type_id",type)
                .gt(StringUtils.isNotBlank(gt),"p_price",gt)
                .lt(StringUtils.isNotBlank(lt),"p_price",lt);
        productInfoService.listObjs(wrapper);
    }
    @Test
    public void test5(){
        //query("红",null,"900",null);
        query(null,null,null,"3000");
    };
}