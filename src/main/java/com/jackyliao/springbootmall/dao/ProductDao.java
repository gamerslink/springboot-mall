package com.jackyliao.springbootmall.dao;

import com.jackyliao.springbootmall.dto.ProductRequest;
import com.jackyliao.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
}
