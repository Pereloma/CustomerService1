package com.example.robofinance.controller.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Customer exists")
public class CustomerExists extends Exception {
}
