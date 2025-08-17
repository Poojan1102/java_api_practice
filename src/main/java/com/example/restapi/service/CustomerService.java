package com.example.restapi.service;
import com.example.restapi.model.CustomerModel;
import com.example.restapi.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository)
    {
        this.repository = repository;
    }

    public List<CustomerModel> getAllCustomer()
    {
        return repository.findAll();
    }

    public Optional<CustomerModel> getCustomerById(Long id)
    {
        return repository.findById(id);
    }

    public CustomerModel createCustomer(CustomerModel customer)
    {
        return repository.save(customer);
    }

    public Optional<CustomerModel> updateCustomer(Long id, CustomerModel customer)
    {
        if (repository.existsById(id)) {
            customer.setId(id);
            return Optional.of(repository.save(customer));
        } else {
            return Optional.empty();
        }
    }

    public void deleteById (Long id)
    {
        if (repository.existsById(id))
        {
            repository.deleteById(id);
        }
        else
        {
            throw new RuntimeException("Book not found of id: " + id);
        }
    }
}
