package com.axemandev.stocksimulator.repository;

import com.axemandev.stocksimulator.model.Stock;

import java.util.List;

public interface StockRepository {
    public List<Stock> getAllStocks();
    public Stock getStockById(String stockId);
    public Boolean updateStock(Stock stock);
    public void loadStocks(List<Stock> stocks);
}
