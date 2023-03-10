package com.example.demo.model.dao;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse {

    private String originCurrency;

    private String finalCurrency;

    private String date;

    private String value;

}
