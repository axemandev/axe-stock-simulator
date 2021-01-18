package com.axemandev.stocksimulator.model;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Builder
@ToString
public class Stock {
    private String companyName;
    private String stockId;
    private Exchange exchange;
    private Sector sector;
    private Double fluctuationFactor;
    @Setter(AccessLevel.PUBLIC)
    private Long totalUnits;
    @Setter(AccessLevel.PUBLIC)
    private Double unitPrice;
    private String uom;
    @Setter(AccessLevel.PUBLIC)
    private ZonedDateTime effectiveAsOf;
}
