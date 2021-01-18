package com.axemandev.stocksimulator.mapper;

import com.axemandev.stocksimulator.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Properties;

public interface StockMapper {
    Stock propertiesToStock(Properties properties);
}
