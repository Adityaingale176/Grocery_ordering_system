package com.Grocery.Grocery_ordering_system.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.Grocery.Grocery_ordering_system.DTO.GroceryDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    private Double price;

    // Many orders belong to one customer
    @ManyToOne
    @JoinColumn(name ="customer_id", nullable = false)  //name = "customer_id": Defines the name of the foreign key column in the Order table, nullable = false: Ensures that this column cannot be null, 
    private Customer customer; 

     // An order can contain many grocery items
    @ManyToMany
    @JoinTable(
        name= "order_grocery",                                                              //name = "order_grocery": This is the name of the join table. 
        joinColumns = @JoinColumn(name = "order_id"),                                      //order_id: The name of the column in the order_grocery table that refers to the Order entity’s primary key.
        inverseJoinColumns = @JoinColumn(name = "grocery_id")                              // grocery_id: This specifies the foreign key from the Grocery entity in the join table:
    )
    private List<Grocery> groceryItems = new ArrayList<>();

}
