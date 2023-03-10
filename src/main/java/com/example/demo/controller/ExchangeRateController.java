package com.example.demo.controller;

import com.example.demo.business.ExchangeService;
import com.example.demo.model.dao.ExchangeRateResponse;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeService service;


    @GetMapping("/get-rate")
    public Single<ExchangeRateResponse> getExchangeRate(@RequestParam("originCurrency") String originCurrency,
                                                        @RequestParam("finalCurrency") String finalCurrency){
        return service.getExchangeRate(originCurrency, finalCurrency);
    }

    @GetMapping("/example")
    public void getCountChain(@RequestParam("chain") String chain){
        service.getCountChain(chain);
    }


}
