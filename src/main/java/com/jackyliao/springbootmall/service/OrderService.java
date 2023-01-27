package com.jackyliao.springbootmall.service;

import com.jackyliao.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer orderId, CreateOrderRequest createOrderRequest);

}
