package com.zs.tmall.service;

import com.zs.tmall.pojo.ProductImage;

import java.util.List;


public interface ProductImageService {

    String TYPE_SINGLE = "type_single";
    String TYPE_DETAIL = "type_detail";

    /**
     * 增加图片信息
     * @param productImage
     */
    void add(ProductImage productImage);

    /**
     * 删除图片信息
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新图片信息
     * @param productImage
     */
    void update(ProductImage productImage);

    /**
     * 根据id获取图片信息
     * @param id
     * @return
     */
    ProductImage get(Integer id);

    /**
     * 获取商品的图片信息
     * @param pid
     * @param type
     * @return
     */
    List<ProductImage> list(Integer pid, String type);
}
