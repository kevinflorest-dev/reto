package com.bcp.exchange.rate.business;

import com.bcp.exchange.rate.model.dao.response.ExchangeRateResponse;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ExchangeService {
    Single<ExchangeRateResponse> getExchangeRate(String val1, String val2);

    Observable<ExchangeRateResponse> getAllExchangeRate();

    void getMatrizByValue(String userValue);

}
