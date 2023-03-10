package com.example.demo.model.assembler;

import com.example.demo.model.dao.ExchangeRateResponse;
import com.example.demo.model.dao.LocalApiResponse;
import com.example.demo.model.entity.ExchangeRate;

public class ExchangeRateAssembler {

    public static ExchangeRateResponse toResponse(ExchangeRate exchangeRate){
        return ExchangeRateResponse.builder()
                .originCurrency(exchangeRate.getOriginCurrency())
                .finalCurrency(exchangeRate.getFinalCurrency())
                .date(exchangeRate.getDate())
                .value(exchangeRate.getValue())
                .build();
    }

    public static ExchangeRate toRequestDB(LocalApiResponse localApiResponse, String finalCurrency){
        return ExchangeRate.builder()
                .originCurrency(localApiResponse.getBase())
                .finalCurrency(finalCurrency)
                .date(localApiResponse.getDate())
                .value(String.valueOf(localApiResponse.getRates().get(finalCurrency)))
                .build();
    }

}
