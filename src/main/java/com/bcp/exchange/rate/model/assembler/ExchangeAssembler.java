package com.bcp.exchange.rate.model.assembler;

import com.bcp.exchange.rate.model.dao.api.LocalApiResponse;
import com.bcp.exchange.rate.model.dao.response.ExchangeRateResponse;
import com.bcp.exchange.rate.model.entity.ExchangeRate;

public class ExchangeAssembler {

    public static ExchangeRateResponse toResponse(ExchangeRate exchangeRate){
        return ExchangeRateResponse.builder()
                .originCurrency(exchangeRate.getOriginCurrency())
                .finalCurrency(exchangeRate.getFinalCurrency())
                .value(exchangeRate.getValue())
                .date(exchangeRate.getDate())
                .build();
    }

    public static ExchangeRate localApiToEntity(String destination, LocalApiResponse localApiResponse){
        return ExchangeRate.builder()
                .originCurrency(localApiResponse.getBase())
                .finalCurrency(destination)
                .value(String.valueOf(localApiResponse.getRates().get(destination)))
                .date(localApiResponse.getDate())
                .build();
    }


}
