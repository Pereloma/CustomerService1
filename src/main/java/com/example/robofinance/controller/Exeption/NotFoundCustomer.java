package com.example.robofinance.controller.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found customer")
public class NotFoundCustomer extends Exception {
}
