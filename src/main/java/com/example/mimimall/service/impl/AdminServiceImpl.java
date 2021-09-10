package com.example.mimimall.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mimimall.entity.Admin;
import com.example.mimimall.mapper.AdminMapper;
import com.example.mimimall.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mimimall.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-09-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(String name,String pwd){
        QueryWrapper<Admin> wrapper=new QueryWrapper();
        String md5= MD5Util.getMD5(pwd);
        wrapper
                .eq("a_name", name)
                .eq("a_pass", md5);
        Admin admin=adminMapper.selectOne(wrapper);
        return admin;

    }

}
