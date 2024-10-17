package com.Grocery.Grocery_ordering_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grocery.Grocery_ordering_system.DTO.OrdersDTO;
import com.Grocery.Grocery_ordering_system.Entity.Orders;
import com.Grocery.Grocery_ordering_system.Service.OrderServiceImpl;


@RestController
@RequestMapping("/api/orders")
public class OrderController{

    @Autowired
    public OrderServiceImpl orderServiceImpl;

    @PostMapping
    public ResponseEntity<OrdersDTO> createOrder(@RequestBody OrdersDTO ordersDTO) {
        OrdersDTO orderDTO = orderServiceImpl.createOrder(ordersDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrdersDTO> updateOrder (@RequestBody OrdersDTO ordersDTO){
        OrdersDTO orderDTO = orderServiceImpl.updateOrder(ordersDTO);
        return ResponseEntity.ok(orderDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrdersDTO> deleteOrder(@PathVariable Long id){
        orderServiceImpl.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getorder/{id}")
    public ResponseEntity<OrdersDTO> getOrder(@PathVariable Long id){
        OrdersDTO ordersDTO = orderServiceImpl.getOrderById(id);
        return ResponseEntity.ok(ordersDTO);
    }

    @GetMapping("/getallorders")
    public ResponseEntity<List<OrdersDTO>> getAllOrders(){
        List<OrdersDTO> ordersDTO = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(ordersDTO);
    }

}