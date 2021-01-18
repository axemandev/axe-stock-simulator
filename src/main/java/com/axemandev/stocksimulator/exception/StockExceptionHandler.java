package com.axemandev.stocksimulator.exception;

import com.axemandev.stocksimulator.exception.model.ExceptionResponse;
import com.axemandev.stocksimulator.exception.model.InvalidPurchaseRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class StockExceptionHandler {

    @ExceptionHandler(InvalidPurchaseRequest.class)
    public ResponseEntity<ExceptionResponse> genericException(HttpServletRequest request, InvalidPurchaseRequest e) {
        ExceptionResponse response = ExceptionResponse.builder()
                .errorCode(1200000)
                .errorMessage("INVALID_PURCHASE_REQUEST")
                .description(e.getMessage())
                .build();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> genericException(HttpServletRequest request, Exception e) {
        ExceptionResponse response = ExceptionResponse.builder()
                .errorCode(9999999)
                .errorMessage("GENERIC_ERROR")
                .description(e.getMessage())
                .build();
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
