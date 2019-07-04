package com.zs.tmall.service;

import com.zs.tmall.pojo.Category;
import com.zs.tmall.util.Page;

import java.util.List;

public interface CategoryService {
    /**
     * 查询总数
     * @return
     */
//    int total();

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<Category> list(Page page);

    List<Category> list();

    /**
     * 添加
     * @param category
     */
    void add(Category category);

    /**
     * 删除
     * @param id
     */
    void delete(int id);

    /**
     * 根据id获取category
     * @param id
     * @return
     */
    Category get(int id);

    /**
     * 更新
     * @param category
     */
    void update(Category category);
}
