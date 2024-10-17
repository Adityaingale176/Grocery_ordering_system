package com.Grocery.Grocery_ordering_system.DTO;

import java.util.List;

import com.Grocery.Grocery_ordering_system.Entity.Orders;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryDTO {

    private Long id;

    private String name;

    private String category;

    private Double price;

    private int quantity;

}
