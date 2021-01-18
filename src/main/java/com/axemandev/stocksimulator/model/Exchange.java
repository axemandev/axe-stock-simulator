package com.axemandev.stocksimulator.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Exchange {
    NSE ("National Stock Exchange"),
    BSE ("Bombay Stock Exchange");

    private String publishedName;

}
