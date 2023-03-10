package com.bcp.exchange.rate.model.dao.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse {

    private String originCurrency;
    private String finalCurrency;
    private String date;
    private String value;

}
