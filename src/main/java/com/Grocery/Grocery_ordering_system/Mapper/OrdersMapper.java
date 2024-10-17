package com.Grocery.Grocery_ordering_system.Mapper;

import com.Grocery.Grocery_ordering_system.DTO.GroceryDTO;
import com.Grocery.Grocery_ordering_system.DTO.OrdersDTO;
import com.Grocery.Grocery_ordering_system.Entity.Customer;
import com.Grocery.Grocery_ordering_system.Entity.Grocery;
import com.Grocery.Grocery_ordering_system.Entity.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersMapper {

    public static Orders mapToOrder(OrdersDTO ordersDTO, Customer customer){

        Orders order = new Orders();
        order.setId(ordersDTO.getId());
        order.setOrderDate(ordersDTO.getOrderDate());
        order.setPrice(ordersDTO.getPrice());
        order.setGroceryItems(ordersDTO.getGroceryItems().stream().map(GroceryMapper::mapToGrocery).collect(Collectors.toList()));
        order.setCustomer(customer);
        return order;
        
    }


    public static OrdersDTO mapToOrdersDTO (Orders order, Customer customer){
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setId(order.getId());
        ordersDTO.setOrderDate(order.getOrderDate());
        ordersDTO.setPrice(order.getPrice());

        List<GroceryDTO> groceryEntities = new ArrayList<>();
        //groceryEntities.add(new GroceryDTO(1L, "Lux", "Soap", 20.0, 3));

        for(Grocery grocery : order.getGroceryItems()){
            GroceryDTO groceryDTO = GroceryMapper.mapToGroceryDTO(grocery);
            groceryEntities.add(groceryDTO);
        }
        ordersDTO.setGroceryItems(groceryEntities);
        ordersDTO.setCustomerId(customer.getId());
        return ordersDTO;
    }   
  
}