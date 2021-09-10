package com.example.mimimall.listener;

import com.example.mimimall.entity.ProductType;
import com.example.mimimall.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class MyListener implements ServletContextListener {
    @Autowired
    ProductTypeService productTypeService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);
        List<ProductType> typeList = productTypeService.list();
        sce.getServletContext().setAttribute("typeList", typeList);
    }


}
