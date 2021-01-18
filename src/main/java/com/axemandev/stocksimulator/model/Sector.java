package com.axemandev.stocksimulator.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Sector {
    MANUFACTURING("Manufacturing"),
    RETAIL("Retail"),
    SERVICES("Services"),
    FINANCE("Finance"),
    REALTY("Real Estate"),
    PETROLEUM("Oil and Petroleum");

    private String publishedName;

}
