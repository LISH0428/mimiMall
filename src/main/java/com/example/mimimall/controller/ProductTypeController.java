package com.example.mimimall.controller;


import com.example.mimimall.entity.ProductType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LISH
 * @since 2021-09-01
 */

@RestController
@RequestMapping("/mimimall/product-type")
public class ProductTypeController {
    @RequestMapping("/admin")
    public ProductType productType(){
        return new ProductType();
    }

}

