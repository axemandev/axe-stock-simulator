package com.axemandev.stocksimulator.repository.impl;

import com.axemandev.stocksimulator.model.Stock;
import com.axemandev.stocksimulator.repository.StockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class InMemoryStockRepositoryImpl implements StockRepository {
    private List<Stock> stocks;

    public InMemoryStockRepositoryImpl() {
        stocks = new ArrayList<>();
    }

    @Override
    public List<Stock> getAllStocks() {
        return this.stocks;
    }

    @Override
    public Stock getStockById(String stockId) {
        return stocks.stream().filter(s -> s.getStockId().equals(stockId)).collect(Collectors.toList()).get(0);
    }

    @Override
    public Boolean updateStock(Stock newStock) {
        try {
            stocks.stream()
                    .filter(s -> s.getStockId().equals(newStock.getStockId()))
                    .map(s -> s = newStock);
            return true;
        } catch (Exception e) {
            log.error("Error encountered in updating stock");
            return false;
        }
    }

    @Override
    public void loadStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
