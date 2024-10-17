package com.Grocery.Grocery_ordering_system.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private List<OrdersDTO> orders;

}
