package com.Grocery.Grocery_ordering_system.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private String name;

    private String category;

    private Double price;

    private int quantity;

    @ManyToMany(mappedBy = "groceryItems")
    private List<Orders> orders = new ArrayList<>();
    
}
