package com.zs.tmall.mapper;

import com.zs.tmall.pojo.Category;
import com.zs.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    List<Category> list(Page page);
    int total();
    void add (Category category);
    void delete(int id);
    Category get(int id);
    void update(Category category);
}
