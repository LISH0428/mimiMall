package com.example.mimimall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mimimall.entity.ProductInfo;
import com.example.mimimall.service.ProductInfoService;
import com.example.mimimall.utils.FileNameUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LISH
 * @since 2021-08-31
 */
@Api(tags = "商品信息")
@Controller
@RequestMapping("/prod")
public class ProductInfoController {
    String saveFileName = "";
    @Autowired
    ProductInfoService productInfoService;

    //不分页全部展示
    @ApiOperation("不分页全部展示")
    @RequestMapping("/getAll")
    public ModelAndView getAll() {
        List<ProductInfo> list = productInfoService.list();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setViewName("product");
        return mv;
    }

    //单个分页展示
    @ApiOperation("单个分页展示")
    @RequestMapping("/split")
    public ModelAndView split() {
        Page<ProductInfo> page = productInfoService.splitPage(1l, 5l);
        List<ProductInfo> list1 = page.getRecords();
        ModelAndView mv = new ModelAndView();
        mv.addObject("info1", page);
        mv.addObject("pages", page.getPages());
        mv.addObject("list", list1);
        mv.setViewName("product");
        return mv;
    }

    //ajax分页展示
    @ApiOperation("ajax分页展示")
    @RequestMapping("/ajaxsplit")
    public @ResponseBody
    void ajaxSplit(Long page, HttpSession session) {
        Page<ProductInfo> page0 = productInfoService.splitPage(page, 5l);
        List<ProductInfo> list1 = page0.getRecords();
        session.setAttribute("list", list1);
        session.setAttribute("info1", page0);
        session.setAttribute("pages", page0.getPages());

    }

    //ajax图片上传
    @ApiOperation("ajax图片上传")
    @RequestMapping("/ajaxImg")
    public @ResponseBody
    Object ajaxImg(MultipartFile pimage, HttpServletRequest request) {
        saveFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(pimage.getOriginalFilename());
        String path = request.getServletContext().getRealPath("/image_big");
        try {
            pimage.transferTo(new File(path + File.separator + saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = new JSONObject();
        object.put("imgurl", saveFileName);

        return object.toString();

    }

    //新增商品
    @ApiOperation("新增商品")
    @RequestMapping("/save")
    public String save(ProductInfo productInfo, HttpServletRequest request) {
        productInfo.setpImage(saveFileName);
        productInfo.setpDate(new Date());
        Boolean flag = false;
        try {
            flag = productInfoService.save(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == false)
            request.setAttribute("msg", "增加失败");
        else
            request.setAttribute("msg", "增加成功");
        saveFileName = "";
        return "forward:/prod/split";
    }

    //更新回显
    @ApiOperation("更新回显")
    @RequestMapping("/one")
    public String one(Integer pid, Model model) {
        ProductInfo info = productInfoService.getById(pid);
        model.addAttribute("prod", info);
        return "update";
    }

    //更新
    @ApiOperation("更新")
    @RequestMapping("/update")
    public String update(ProductInfo info, HttpServletRequest request) {
        if (!saveFileName.equals(""))
            info.setpImage(saveFileName);
        boolean flag = false;
        try {
            flag = productInfoService.updateById(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == false)
            request.setAttribute("msg", "更新失败");
        else
            request.setAttribute("msg", "更新成功");
        saveFileName = "";
        return "forward:/prod/split";
    }

    //单个删除
    @ApiOperation("单个删除")
    @RequestMapping("/delete")
    public String delete(int pid, HttpServletRequest request) {
        try {
            boolean flag = false;
            flag = productInfoService.removeById(pid);
            if (flag == false)
                request.setAttribute("msg", "删除失败");
            else
                request.setAttribute("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/prod/deleteAjaxSplit";
    }

    //批量删除
    @ApiOperation("批量删除")
    @RequestMapping("/deleteBatch")
    public String deleteBatch(String str,HttpServletRequest request){
        String[] split=str.split(",");
        try {
            Boolean flag=false;
            flag=productInfoService.removeByIds(Arrays.asList(split));
            if (flag == false)
                request.setAttribute("msg", "删除失败");
            else
                request.setAttribute("msg", "删除成功");
        } catch (Exception e) {
            request.setAttribute("msg","商品不可删除");
        }

        return "forward:/prod/deleteAjaxSplit";
    }
    //删除后异步刷新
    @ApiOperation("删除后异步刷新")
    @ResponseBody
    @RequestMapping(value ="/deleteAjaxSplit",produces = "text/html;charset=UTF-8")
    public Object deleteAjaxSplit(HttpServletRequest request){
        HttpSession session = request.getSession();
        Page<ProductInfo> page = productInfoService.splitPage(1l, 5l);
        List<ProductInfo> list1 = page.getRecords();
        session.setAttribute("list", list1);
        session.setAttribute("info1", page);
        session.setAttribute("pages", page.getPages());
        return request.getAttribute("msg");
    }
    //多条件查询
    //TODO 翻页不保留查询结果
    @ApiOperation("多条件查询")
    @ResponseBody
    @RequestMapping("/condition")
    public void condition(String pName,String typeId,String minPrice,String maxPrice,HttpSession session){
        QueryWrapper<ProductInfo> wrapper=new QueryWrapper();
        wrapper.like(StringUtils.isNotBlank(pName),"p_name",pName)
                .eq(StringUtils.isNotBlank(typeId),"type_id",typeId)
                .gt(StringUtils.isNotBlank(minPrice),"p_price",minPrice)
                .lt(StringUtils.isNotBlank(maxPrice),"p_price",maxPrice);
        Page<ProductInfo> page=new Page<ProductInfo>(1l,5l);
        productInfoService.page(page,wrapper);
        List<ProductInfo> list = page.getRecords();
        session.setAttribute("list", list);
        session.setAttribute("info1", page);
        session.setAttribute("pages", page.getPages());

    }
    //swagger 显示model
    @RequestMapping("/user")
    public ProductInfo productInfo(){
        return new ProductInfo();
    }
}

