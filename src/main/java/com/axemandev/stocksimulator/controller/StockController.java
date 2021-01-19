package com.axemandev.stocksimulator.controller;

import com.axemandev.stocksimulator.exception.model.InvalidPurchaseRequest;
import com.axemandev.stocksimulator.model.Stock;
import com.axemandev.stocksimulator.model.StockPurchaseRequest;
import com.axemandev.stocksimulator.model.StockPurchaseResponse;
import com.axemandev.stocksimulator.service.StockService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    public StockService stockService;

    @ApiOperation(value = "List all stocks across all the stock boards")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="lang", dataType = "string", paramType = "header", required = false, example = "en")
    })
    @GetMapping("/")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{stockId}")
    public Stock getStockById(@PathVariable("stockId") String stockId) {
        return stockService.getStockById(stockId);
    }

    @PostMapping("/")
    public Boolean updateStock(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }

    @ApiOperation(value = "Post a purchase transaction on a single stock")
    @PostMapping("/buy")
    public ResponseEntity<StockPurchaseResponse> buyStocks(@RequestBody StockPurchaseRequest request) {
        log.info("StockController :: buyStocks - {}", request);
        return new ResponseEntity(stockService.buy(request), HttpStatus.ACCEPTED);
    }
}
