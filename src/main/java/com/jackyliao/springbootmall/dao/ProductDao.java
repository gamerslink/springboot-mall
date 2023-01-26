package com.jackyliao.springbootmall.dao;

import com.jackyliao.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
