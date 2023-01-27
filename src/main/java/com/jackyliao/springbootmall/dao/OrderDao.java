package com.jackyliao.springbootmall.dao;

import com.jackyliao.springbootmall.dto.OrderQueryParams;
import com.jackyliao.springbootmall.model.Order;
import com.jackyliao.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    void createOrderListItems(Integer orderId, List<OrderItem> orderItemList);

    Integer createOrder(Integer userId, Integer totalAmount);

}
