package com.example.robofinance.controller;

import com.example.robofinance.controller.Exeption.*;
import com.example.robofinance.entity.Address;
import com.example.robofinance.entity.Customer;
import com.example.robofinance.repository.AddressRepository;
import com.example.robofinance.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ObjectMapper objectMapper;

    @PutMapping("/newCustomer")
    public void newCustomer(@RequestBody String jso) throws JsonProcessingException, InvalidJSONBody {
        Customer customer;
        try {
            customer = objectMapper.readValue(jso, Customer.class);
        } catch (JsonParseException e){
            throw new InvalidJSONBody();
        }

        addressRepository.save(customer.getActualAddressID());
        addressRepository.save(customer.getRegistredAddressID());

        customerRepository.save(customer);

    }

    @GetMapping("/getCustomer")
    public List<Customer> getCustomer(
            @RequestParam(name = "firstName",required = false) String firstName,
            @RequestParam(name = "lastName",required = false) String lastName) throws NotFoundCustomer {

        if(lastName != null && !lastName.isBlank()) {
            if (firstName != null && !firstName.isBlank()){
                return customerRepository.findByLastNameAndFirstNameAllIgnoreCase(lastName,firstName);
            }
            else {
                return customerRepository.findAllByLastName(lastName);
            }
        }
        else if(firstName != null && !firstName.isBlank()){
            return customerRepository.findAllByLastName(lastName);
        }
        else throw new NotFoundCustomer();
    }
}
