package com.bcp.exchange.rate.web;

import com.bcp.exchange.rate.business.ExchangeService;
import com.bcp.exchange.rate.model.dao.response.ExchangeRateResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/exchange-rate")
@RestController
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService service;

    @GetMapping
    public Single<ExchangeRateResponse> getExchangeRate(@RequestParam("originCurrency") String originCurrency,
                                                        @RequestParam("finalCurrency") String finalCurrency)
    {
        return service.getExchangeRate(originCurrency,finalCurrency);
    }

    @GetMapping("/list")
    public Observable<ExchangeRateResponse> getAllExchangeRate(){
        return service.getAllExchangeRate();
    }

    @GetMapping("/matriz")
    public void getMatrizByValue(@RequestParam("userValue") String userValue){
        service.getMatrizByValue(userValue);
    }

}
