package com.example.robofinance.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.robofinance.entity.Address;
import com.example.robofinance.entity.Customer;
import com.example.robofinance.repository.AddressRepository;
import com.example.robofinance.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.Assert;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;

    private static String FIRST_NAME = "firstNameTest";
    private static String LAST_NAME = "lastNameTest";



    @Test
    void newCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setSex("male");
        customer.setActualAddressID(new Address());
        customer.setRegistredAddressID(new Address());

        MockHttpServletRequestBuilder rest = put("/newCustomer");
        rest.content(objectMapper.valueToTree(customer).toString());
        this.mvc.perform(rest).andDo(print()).andExpect(status().isOk());

        customerRepository.delete(customer);
        addressRepository.delete(customer.getActualAddressID());
        addressRepository.delete(customer.getRegistredAddressID());
    }

    @Test
    void getCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setSex("male");
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setActualAddressID(new Address());
        customer.setRegistredAddressID(new Address());
        addressRepository.save(customer.getActualAddressID());
        addressRepository.save(customer.getRegistredAddressID());
        customerRepository.save(customer);


        MockHttpServletRequestBuilder rest = get("/getCustomer");
        rest.param("firstName",FIRST_NAME);
        rest.param("lastName",LAST_NAME);
        ResultActions resultActions = this.mvc.perform(rest).andDo(print()).andExpect(status().isOk());
        Customer[] customers = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(),Customer[].class);
        assertThat(customers).contains(customers);


        customerRepository.delete(customer);
        addressRepository.delete(customer.getActualAddressID());
        addressRepository.delete(customer.getRegistredAddressID());

    }
}