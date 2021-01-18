package com.axemandev.stocksimulator.model;

import lombok.Data;

@Data
public class StockPurchaseRequest {
    private String stockId;
    private Long units;
    private String purchaser;
}
