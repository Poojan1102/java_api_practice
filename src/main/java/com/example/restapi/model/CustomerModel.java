package com.example.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;


// To say this is DB table

@Entity
@Table(name="CUSTOMER")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Getter and Setters

    public CustomerModel()
    {}

    public CustomerModel(String firstName, String lastName, String phoneNumber)
    {
     
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
            return firstName;       
    }

    public void setFirstName(String firstName)
    {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (firstName.length() > 30) {
            throw new IllegalArgumentException("First name is too long");
        }
        if (!firstName.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("First name must contain only letters");
        }
        if (firstName.length() < 2) {
            throw new IllegalArgumentException("First name is too short");
        }
        // If all valid
        else{
            this.firstName = firstName.trim().toLowerCase();
        }
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
           if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (lastName.length() > 30) {
            throw new IllegalArgumentException("Last name is too long");
        }
        if (!lastName.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Last name must contain only letters");
        }
        if (lastName.length() < 2) {
            throw new IllegalArgumentException("Last name is too short");
        }
        // If all valid
        else{
            this.lastName = lastName.trim().toLowerCase();
        }
    }

    public String getPhoneNumber()
    {
        return phoneNumber; 
        
    }

    public void setPhoneNumber(String phoneNumber)
    {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        if (phoneNumber.length() > 15) {
            throw new IllegalArgumentException("Phone number is too long");
        }
        if (!phoneNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Phone number must contain only digits");
        }
        if (phoneNumber.length() < 10) {
            throw new IllegalArgumentException("Phone number is too short");
        }
        // If all valid
        else{
        this.phoneNumber = phoneNumber.trim();
        }
    }
}
