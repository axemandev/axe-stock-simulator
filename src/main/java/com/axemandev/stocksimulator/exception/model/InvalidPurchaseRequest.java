package com.axemandev.stocksimulator.exception.model;

public class InvalidPurchaseRequest extends RuntimeException{
    public InvalidPurchaseRequest(String description) {
        super(description);
    }
}
