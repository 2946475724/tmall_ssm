package com.zs.tmall.controller;

import com.zs.tmall.pojo.Category;
import com.zs.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class ForeController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("forehome")
    public String home(Model model){
        List<Category> cs = categoryService.list();

        return "/fore/home";
    }

}
