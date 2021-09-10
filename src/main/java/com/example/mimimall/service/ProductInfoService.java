package com.example.mimimall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mimimall.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface ProductInfoService extends IService<ProductInfo> {
    Page<ProductInfo> splitPage(Long pageNum,Long pageSize);
}
