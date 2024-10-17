package com.Grocery.Grocery_ordering_system.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Grocery.Grocery_ordering_system.Entity.Customer;
import com.Grocery.Grocery_ordering_system.Entity.Grocery;
import com.Grocery.Grocery_ordering_system.Controller.OrderController;
import com.Grocery.Grocery_ordering_system.DTO.GroceryDTO;
import com.Grocery.Grocery_ordering_system.DTO.OrdersDTO;
import com.Grocery.Grocery_ordering_system.Entity.Orders;
import com.Grocery.Grocery_ordering_system.Mapper.GroceryMapper;
import com.Grocery.Grocery_ordering_system.Mapper.OrdersMapper;
import com.Grocery.Grocery_ordering_system.Repository.CustomerRespository;
import com.Grocery.Grocery_ordering_system.Repository.OrderRepository;
import com.Grocery.Grocery_ordering_system.Repository.GroceryRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private CustomerRespository customerRespository;
    private GroceryRepository groceryRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRespository customerRespository, GroceryRepository groceryRepository){
        this.orderRepository = orderRepository;
        this.customerRespository = customerRespository;
        this.groceryRepository = groceryRepository;
    }

    @Override
    public OrdersDTO createOrder(OrdersDTO ordersDTO) {

       Customer customer = customerRespository.findById(ordersDTO.getCustomerId()).orElseThrow(()-> new EntityNotFoundException());         //Fetch customer from DB
       Orders order = OrdersMapper.mapToOrder(ordersDTO, customer);                                                                         //map DTO to order entity
        List<Grocery> groceryEntities = new ArrayList<>();

        for(GroceryDTO groceryDTO : ordersDTO.getGroceryItems()){
            Grocery grocery = GroceryMapper.mapToGrocery(groceryDTO);
            grocery = groceryRepository.save(grocery);
            groceryEntities.add(grocery);
        }
        
        order.setGroceryItems(groceryEntities);
        Orders savedOrder = orderRepository.save(order);
        return OrdersMapper.mapToOrdersDTO(savedOrder, customer);
        
    }

    @Override
    public OrdersDTO updateOrder(OrdersDTO ordersDTO) {
        if(ordersDTO.getId() == null){
            throw new EntityNotFoundException("id not found");
        }
        Customer customer = customerRespository.findById(ordersDTO.getCustomerId()).orElseThrow(()->new EntityNotFoundException("Customer not found"));
        Orders order = OrdersMapper.mapToOrder(ordersDTO, customer);
        Orders savedOrder = orderRepository.findById(order.getId()).orElseThrow(()-> new EntityNotFoundException("Saved order not found"));
        if(savedOrder != null){
            savedOrder.setGroceryItems(order.getGroceryItems());
            savedOrder.setOrderDate(order.getOrderDate());
            savedOrder.setPrice(order.getPrice());
        }
        Orders updatedOrder = orderRepository.save(savedOrder);
        return OrdersMapper.mapToOrdersDTO(updatedOrder, customer);
    }

    @Override
    public void deleteOrder(Long id) {
        Orders order = orderRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Order id do not exist"));
        orderRepository.deleteById(id);
        //return OrdersMapper.mapToOrdersDTO(order, order.getCustomer());
    }

    @Override
    public OrdersDTO getOrderById(Long id) {
        Orders order = orderRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Order id do no exist"));
        return OrdersMapper.mapToOrdersDTO(order, order.getCustomer());
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        
        List<OrdersDTO> ordersDTO = new ArrayList<>();
        for (Orders order : orders){
            ordersDTO.add(OrdersMapper.mapToOrdersDTO(order, order.getCustomer()));
        }
        return ordersDTO;
    }
}
