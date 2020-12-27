package com.example.robofinance.controller;

import com.example.robofinance.controller.Exeption.InvalidRequestAddressType;
import com.example.robofinance.entity.Address;
import com.example.robofinance.entity.Customer;
import com.example.robofinance.repository.AddressRepository;
import com.example.robofinance.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/editAddress")
    public void EditAddress(@RequestParam(name = "id",required = false) Long addressID,
                            @RequestBody String jso) throws JsonProcessingException{

        Address address = objectMapper.readValue(jso, Address.class);
        address.setId(addressID);

            addressRepository.save(address);


    }
}
