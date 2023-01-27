package com.jackyliao.springbootmall.service;

import com.jackyliao.springbootmall.dto.CreateOrderRequest;
import com.jackyliao.springbootmall.model.Order;

public interface OrderService {

    Integer createOrder(Integer orderId, CreateOrderRequest createOrderRequest);
    Order getOrderById(Integer orderId);

}
