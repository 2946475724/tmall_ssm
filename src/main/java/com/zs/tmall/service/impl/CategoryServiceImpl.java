package com.zs.tmall.service.impl;

import com.zs.tmall.mapper.CategoryMapper;
import com.zs.tmall.pojo.Category;
import com.zs.tmall.pojo.CategoryExample;
import com.zs.tmall.service.CategoryService;
import com.zs.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

//    @Override
//    public int total() {
//        return categoryMapper.total();
//    }
//
//    @Override
//    public List<Category> list(Page page) {
//        return categoryMapper.list(page);
//    }
//
//    @Override
//    public void add(Category category) {
//        categoryMapper.add(category);
//    }
//
//    @Override
//    public void delete(int id) {
//        categoryMapper.delete(id);
//    }
//
//    @Override
//    public Category get(int id) {
//        return categoryMapper.get(id);
//    }
//
//    @Override
//    public List<Category> list() {
//        return null;
//    }
//
//    @Override
//    public void update(Category category) {
//        categoryMapper.update(category);
//    }

    @Override
    public List<Category> list(Page page) {
        return null;
    }

    @Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int id) {
        /**
         * 需要级联删除
         */
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
