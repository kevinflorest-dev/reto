package com.example.demo.business;

import com.example.demo.model.dao.ExchangeRateResponse;
import io.reactivex.Single;

public interface ExchangeService {

    Single<ExchangeRateResponse> getExchangeRate(String originCurrency, String finalCurrency);

    void getCountChain(String chain);
}
