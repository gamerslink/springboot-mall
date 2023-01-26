package com.jackyliao.springbootmall.service;

import com.jackyliao.springbootmall.constant.ProductCategory;
import com.jackyliao.springbootmall.dto.ProductRequest;
import com.jackyliao.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
