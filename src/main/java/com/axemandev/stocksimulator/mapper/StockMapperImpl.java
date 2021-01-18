package com.axemandev.stocksimulator.mapper;

import com.axemandev.stocksimulator.model.Exchange;
import com.axemandev.stocksimulator.model.Sector;
import com.axemandev.stocksimulator.model.Stock;

import java.time.ZonedDateTime;
import java.util.Properties;

public class StockMapperImpl implements StockMapper {

    @Override
    public Stock propertiesToStock(Properties properties) {
        return Stock.builder()
                .companyName(properties.getProperty("companyName"))
                .stockId(properties.getProperty("stockId"))
                .exchange(Exchange.valueOf(properties.getProperty("exchange")))
                .sector(Sector.valueOf(properties.getProperty("sector")))
                .fluctuationFactor(Double.valueOf(properties.getProperty("fluctuationFactor")))
                .totalUnits(Long.valueOf(properties.getProperty("totalUnits")))
                .unitPrice(Double.valueOf(properties.getProperty("unitPrice")))
                .uom(properties.getProperty("uom"))
                .effectiveAsOf(ZonedDateTime.now())
                .build();
    }

}
