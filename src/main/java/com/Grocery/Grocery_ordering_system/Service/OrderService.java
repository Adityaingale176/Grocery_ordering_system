package com.Grocery.Grocery_ordering_system.Service;

import java.util.List;

import com.Grocery.Grocery_ordering_system.DTO.OrdersDTO;

public interface OrderService {

    OrdersDTO createOrder(OrdersDTO ordersDTO);

    OrdersDTO updateOrder(OrdersDTO ordersDTO);

    void deleteOrder(Long id);

    OrdersDTO getOrderById(Long id);

    List<OrdersDTO> getAllOrders();

}
