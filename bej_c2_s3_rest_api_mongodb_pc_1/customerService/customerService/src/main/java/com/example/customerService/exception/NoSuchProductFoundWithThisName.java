package com.example.customerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT ,reason = "No Such Product Found With This Name")
public class NoSuchProductFoundWithThisName extends Exception {
}
