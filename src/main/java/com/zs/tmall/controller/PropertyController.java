package com.zs.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.tmall.pojo.Category;
import com.zs.tmall.pojo.Property;
import com.zs.tmall.service.CategoryService;
import com.zs.tmall.service.PropertyService;
import com.zs.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("admin_property_add")
    public String add(Property property){
        propertyService.add(property);
        return "redirect:/admin_property_list?cid="+property.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String delete(Integer id){
        Property property = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?cid="+property.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String edit(Model model, Integer id){
        Property property = propertyService.get(id);
        Category category = categoryService.get(property.getCid());
        property.setCategory(category);
        model.addAttribute("property",property);
        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String update(Property property){
        propertyService.update(property);
        return "redirect:admin_property_list?cid="+property.getCid();
    }

    @RequestMapping("admin_property_list")
    public String list(int cid, Model model, Page page){
        Category category = categoryService.get(cid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Property> propertyList = propertyService.list(cid);
        int total =(int)new PageInfo<>(propertyList).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+category.getId());
        model.addAttribute("propertyList",propertyList);
        model.addAttribute("category",category);
        model.addAttribute("page",page);
        return "admin/listProperty";
    }
}
