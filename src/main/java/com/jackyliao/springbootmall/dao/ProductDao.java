package com.jackyliao.springbootmall.dao;

import com.jackyliao.springbootmall.dto.ProductQueryParams;
import com.jackyliao.springbootmall.dto.ProductRequest;
import com.jackyliao.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void updateStock(Integer productId, Integer stock);

    void deleteProductById(Integer productId);
}
