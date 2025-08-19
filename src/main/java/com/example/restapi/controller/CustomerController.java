package com.example.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.CustomerModel;
import com.example.restapi.service.CustomerService;

import java.util.UUID;

@RestController
@RequestMapping("/customer")

public class CustomerController{
    
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerModel> getAllCustomer(){
        return service.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Optional<CustomerModel> getCustomerById(@PathVariable UUID id){
        return service.getCustomerById(id);
    }

    @PostMapping
    public CustomerModel createCustomer(@RequestBody CustomerModel customer)
    {
        return service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerModel> updateCustomer(@PathVariable UUID id, @RequestBody CustomerModel customer)
    {
        return service.updateCustomer(id,customer)
        .map(updatedCustomer -> ResponseEntity.ok(updatedCustomer))
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id)
    {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

  
}
