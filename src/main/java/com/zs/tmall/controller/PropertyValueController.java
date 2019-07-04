package com.zs.tmall.controller;

import com.zs.tmall.pojo.Product;
import com.zs.tmall.pojo.PropertyValue;
import com.zs.tmall.service.ProductService;
import com.zs.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyValueController {

    @Autowired
    private PropertyValueService propertyValueService;

    @Autowired
    private ProductService productService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model, Integer pid){
        Product product = productService.get(pid);

        propertyValueService.init(product);

        List<PropertyValue> list = propertyValueService.list(pid);

        model.addAttribute("product",product);
        model.addAttribute("list",list);
        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue propertyValue){
        propertyValueService.update(propertyValue);
        return "success";
    }



}
