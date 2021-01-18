package com.axemandev.stocksimulator.exception.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionResponse {
    private int errorCode;
    private String errorMessage;
    private String description;
}
