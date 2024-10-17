package com.Grocery.Grocery_ordering_system.Mapper;

import com.Grocery.Grocery_ordering_system.DTO.GroceryDTO;
import com.Grocery.Grocery_ordering_system.Entity.Grocery;

public class GroceryMapper {


    public static GroceryDTO mapToGroceryDTO(Grocery grocery) {
        
        GroceryDTO groceryDTO = new GroceryDTO();
        groceryDTO.setId(grocery.getId());
        groceryDTO.setCategory(grocery.getCategory());
        groceryDTO.setPrice(grocery.getPrice());
        groceryDTO.setQuantity(grocery.getQuantity());
        groceryDTO.setName(grocery.getName());

        return groceryDTO;
    }

    public static Grocery mapToGrocery(GroceryDTO groceryDTO){

        Grocery grocery = new Grocery();
        grocery.setId(groceryDTO.getId());
        grocery.setName(groceryDTO.getName());
        grocery.setCategory(groceryDTO.getCategory());
        grocery.setPrice(groceryDTO.getPrice());
        grocery.setQuantity(groceryDTO.getQuantity());

        return grocery;
    }
        
}
