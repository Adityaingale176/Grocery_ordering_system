package com.Grocery.Grocery_ordering_system.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grocery.Grocery_ordering_system.DTO.CustomerDTO;
import com.Grocery.Grocery_ordering_system.Entity.Customer;
import com.Grocery.Grocery_ordering_system.Mapper.CustomerMapper;
import com.Grocery.Grocery_ordering_system.Repository.CustomerRespository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRespository customerRespository;
    
    @Autowired
    public CustomerServiceImpl(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        Customer savedCustomer = customerRespository.save(customer);
        return CustomerMapper.mapCustomerDTO(savedCustomer);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRespository.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer does not exist"));
        return CustomerMapper.mapCustomerDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomerEmail(Long id, String email) {
        Customer customer = customerRespository.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer does not exist"));
        customer.setEmail(email);
        Customer savedCustomer = customerRespository.save(customer);
        return CustomerMapper.mapCustomerDTO(savedCustomer);
    }

    @Override
    public CustomerDTO deleteCustomer(Long id) {
        Customer customerToBeDeleted = customerRespository.findById(id).orElseThrow(()->new EntityNotFoundException("Customer with Id "+id+" not found"));
        customerRespository.deleteById(id);
        return CustomerMapper.mapCustomerDTO(customerToBeDeleted);   
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customersList = customerRespository.findAll();
        return customersList.stream().map((customerList)->CustomerMapper.mapCustomerDTO(customerList)).collect(Collectors.toList());
    }
}