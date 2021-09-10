package com.example.mimimall.service;

import com.example.mimimall.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-09-01
 */
public interface AdminService extends IService<Admin> {
    public Admin login(String name,String pwd);

}
