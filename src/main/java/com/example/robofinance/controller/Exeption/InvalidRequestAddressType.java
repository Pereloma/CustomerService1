package com.example.robofinance.controller.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid request address_type")
public class InvalidRequestAddressType extends Exception {
}
