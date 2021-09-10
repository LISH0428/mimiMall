package com.example.mimimall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mimimall.entity.ProductInfo;
import com.example.mimimall.mapper.ProductInfoMapper;
import com.example.mimimall.service.ProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LISH
 * @since 2021-08-31
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {
    @Autowired
    ProductInfoMapper productInfoMapper;


    @Override
    public Page<ProductInfo> splitPage(Long pageNum, Long pageSize) {
        Page<ProductInfo> page = new Page<>(pageNum,pageSize);
        page.addOrder(OrderItem.desc("p_id"));
        return productInfoMapper.selectPage(page,null);
    }
}
