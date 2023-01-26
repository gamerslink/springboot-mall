package com.jackyliao.springbootmall.controller;

import com.jackyliao.springbootmall.constant.ProductCategory;
import com.jackyliao.springbootmall.dto.ProductQueryParams;
import com.jackyliao.springbootmall.dto.ProductRequest;
import com.jackyliao.springbootmall.model.Product;
import com.jackyliao.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category, // required = false 非必填
            @RequestParam(required = false) String search,

            // 排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            // 分頁 Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ) {

        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);


       List<Product> productList = productService.getProducts(productQueryParams);

       return ResponseEntity.status(HttpStatus.OK).body(productList);
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if ( product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }


    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {

        // 檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if ( product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId); // 取得更新後的商品數據

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }


    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {

        // 商品存在，成功刪除，商品本來就不存在
        // 前端所在意的不是刪除的動作，是一個結果，商品確定不存在了
        productService.deleteProductById(productId);

        // 返回成功 204 NO_CONTENT
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
