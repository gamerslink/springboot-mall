package com.jackyliao.springbootmall.rowmapper;

import com.jackyliao.springbootmall.constant.ProductCategory;
import com.jackyliao.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        /*
        // String 類型跟 Enum 類型的轉換
        String categoryStr = resultSet.getString("category"); // 用 String 類型變數儲存 resultSet 資料庫取出的值
        // String 轉 Enum
        // 使用Enum類型的valueOf，根據傳入字串的值，找尋對應中的 ProductCategory 中的固定值，回傳到 category 裡面
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);
        */

        // 將上方程式改寫，直接將資料庫取出來的 String 類型的字串，去轉換成 ProductCategory 的 Enum 值，然後把它傳入到 set 方法做設定
        product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));



        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return product;
    }
}
