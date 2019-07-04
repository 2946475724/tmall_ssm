package com.zs.tmall.service;

import com.zs.tmall.pojo.Review;

import java.util.List;

public interface ReviewService {

    void add(Review review);

    void delete(Integer id);

    void update(Review review);

    Review get(Integer id);

    List<Review> list(Integer pid);

    int getCount(Integer pid);
}
