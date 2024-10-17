package com.Grocery.Grocery_ordering_system.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    //mappedBy = the foreign key for the customer is in the Order table, cascade =  Automatically performs all persistence operations (e.g., save, delete) on related orders when a customer is saved or deleted.
    //orphanRemoval = true If an order is removed from the customer’s order list, it will also be deleted from the database
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)          
    private List<Orders> orders = new ArrayList<>();

}
