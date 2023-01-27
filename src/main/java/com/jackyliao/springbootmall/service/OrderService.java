package com.jackyliao.springbootmall.service;

import com.jackyliao.springbootmall.dto.CreateOrderRequest;
import com.jackyliao.springbootmall.dto.OrderQueryParams;
import com.jackyliao.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer createOrder(Integer orderId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

}
