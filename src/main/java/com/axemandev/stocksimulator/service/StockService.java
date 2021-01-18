package com.axemandev.stocksimulator.service;

import com.axemandev.stocksimulator.model.Stock;
import com.axemandev.stocksimulator.model.StockPurchaseRequest;
import com.axemandev.stocksimulator.model.StockPurchaseResponse;

import java.util.List;

public interface StockService {
    public List<Stock> getAllStocks();
    public Stock getStockById(String stockId);
    public Boolean updateStock(Stock stock);
    public void loadStocks(List<Stock> stock);
    public StockPurchaseResponse buy(StockPurchaseRequest request);
}
