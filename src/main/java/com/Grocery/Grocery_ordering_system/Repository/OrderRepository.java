package com.Grocery.Grocery_ordering_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Grocery.Grocery_ordering_system.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{
    
}   
