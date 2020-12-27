package com.example.robofinance.controller;

import com.example.robofinance.entity.Address;
import com.example.robofinance.repository.AddressRepository;
import com.example.robofinance.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void editAddress() throws Exception {
        Address address = new Address();
        addressRepository.save(address);

        MockHttpServletRequestBuilder rest = post("/editAddress");
        rest.param("id",address.getId().toString());
        rest.content(objectMapper.valueToTree(new Address()).toString());
        mvc.perform(rest).andDo(print()).andExpect(status().isOk());


        addressRepository.delete(address);
    }
}