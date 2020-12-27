package com.example.robofinance.controller;

import javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class Help {
String help = "http://localhost:8080/getCustomer?firstName&lastName\nhttp://localhost:8080/editAddress?id&address_type";

    @GetMapping({"/help", "/"})
    public String help() {
        return help;
    }
}
