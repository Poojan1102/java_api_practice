package com.example.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{
    
}
