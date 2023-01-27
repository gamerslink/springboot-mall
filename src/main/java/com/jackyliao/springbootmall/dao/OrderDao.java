package com.jackyliao.springbootmall.dao;

import com.jackyliao.springbootmall.dto.CreateOrderRequest;
import com.jackyliao.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    void createOrderListItems(Integer orderId, List<OrderItem> orderItemList);

    Integer createOrder(Integer userId, Integer totalAmount);

}
