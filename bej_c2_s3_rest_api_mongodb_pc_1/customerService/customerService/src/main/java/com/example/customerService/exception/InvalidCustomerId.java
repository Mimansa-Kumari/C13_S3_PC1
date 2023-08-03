package com.example.customerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT ,reason = "Customer with this CustomerId is already Available"  )
public class InvalidCustomerId extends Exception {
}
