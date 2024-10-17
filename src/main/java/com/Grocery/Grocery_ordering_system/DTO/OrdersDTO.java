package com.Grocery.Grocery_ordering_system.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class OrdersDTO {
    
    private Long id;

    private LocalDate orderDate;

    private Double price;

    private List<GroceryDTO> groceryItems;

    private Long CustomerId;
}
