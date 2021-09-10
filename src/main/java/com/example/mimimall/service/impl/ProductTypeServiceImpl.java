package com.example.mimimall.service.impl;

import com.example.mimimall.entity.ProductType;
import com.example.mimimall.mapper.ProductTypeMapper;
import com.example.mimimall.service.ProductTypeService;
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
 * @since 2021-09-01
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {
    @Autowired
    ProductTypeMapper productTypeMapper;


}
