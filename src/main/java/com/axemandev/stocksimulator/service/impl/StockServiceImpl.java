package com.axemandev.stocksimulator.service.impl;

import com.axemandev.stocksimulator.exception.model.InvalidPurchaseRequest;
import com.axemandev.stocksimulator.model.Stock;
import com.axemandev.stocksimulator.model.StockPurchaseRequest;
import com.axemandev.stocksimulator.model.StockPurchaseResponse;
import com.axemandev.stocksimulator.repository.StockRepository;
import com.axemandev.stocksimulator.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.getAllStocks();
    }

    @Override
    public Stock getStockById(String stockId) {
        return stockRepository.getStockById(stockId);
    }

    @Override
    public Boolean updateStock(Stock stock) {
        return stockRepository.updateStock(stock);
    }

    @Override
    public void loadStocks(List<Stock> stocks) {
        stockRepository.loadStocks(stocks);
    }

    @Override
    public StockPurchaseResponse buy(StockPurchaseRequest request) {
        Stock stock = stockRepository.getStockById(request.getStockId());
        validatePurchase(stock, request);
        StockPurchaseResponse response = StockPurchaseResponse.builder()
                .price(getMonetaryValue(request.getUnits() * stock.getUnitPrice()))
                .units(request.getUnits())
                .transactionId(UUID.randomUUID())
                .build();
        stock.setUnitPrice(getMonetaryValue(getNewPrice(stock, request.getUnits())));
        stock.setTotalUnits(stock.getTotalUnits() - request.getUnits());
        stockRepository.updateStock(stock);
        return response;
    }

    private Double getNewPrice(Stock stock, Long unitsDelta) {
        return stock.getUnitPrice() +
                (unitsDelta * stock.getFluctuationFactor() / stock.getTotalUnits());
    }

    private Double getMonetaryValue(Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return Double.valueOf(decimalFormat.format(value));
    }

    private boolean validatePurchase(Stock stock, StockPurchaseRequest request) {
        if (stock.getTotalUnits() < request.getUnits()) {
            throw new InvalidPurchaseRequest("An attempt was made to purchase " +
                    request.getUnits() + " units. You can not buy more than available (" +
                    stock.getTotalUnits() + ") units");
        }
        return true;
    }

}
