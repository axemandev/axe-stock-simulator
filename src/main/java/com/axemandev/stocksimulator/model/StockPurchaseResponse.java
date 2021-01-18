package com.axemandev.stocksimulator.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class StockPurchaseResponse {
    private UUID transactionId;
    private Long units;
    private Double price;
    private Boolean success;
}
