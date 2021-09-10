package com.example.mimimall.controller;


import com.example.mimimall.entity.Admin;
import com.example.mimimall.entity.ProductInfo;
import com.example.mimimall.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-09-01
 */
@ApiOperation("用户信息controller")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){

        Admin admin = adminService.login(name, pwd);
        if(admin!=null){
            request.setAttribute("admin",admin);
            return "main";
        }
        else{
            request.setAttribute("errmsg","登陆失败，请重新输入");
            return "login";

        }

    }
    //Swagger model
    @PostMapping("/admin")
    public Admin admin(){
        return new Admin();
    }


}

