package com.example.demo.business.impl;

import com.example.demo.api.LocalApi;
import com.example.demo.business.ExchangeService;
import com.example.demo.model.assembler.ExchangeRateAssembler;
import com.example.demo.model.dao.ExchangeRateResponse;
import com.example.demo.model.entity.ExchangeRate;
import com.example.demo.repository.ExchangeRateRepository;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Arrays;

@Service
public class ExchangeRateServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRateRepository repository;

    //@Autowired
    //private LocalApi localApi;

    ExchangeRateServiceImpl(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhsot:3000").addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

         //= retrofit.create(localApi);
    }

    @Override
    public Single<ExchangeRateResponse> getExchangeRate(String originCurrency, String finalCurrency) {
      /*  return Single.create(singleEmitter -> repository.findByOriginCurrencyAndFinalCurrency(originCurrency,finalCurrency)
                .ifPresentOrElse(obj -> {
                    ExchangeRateResponse exchangeRateResponse = ExchangeRateAssembler.toResponse(obj);
                    singleEmitter.onSuccess(exchangeRateResponse);
                }, () -> {
                    ExchangeRateResponse exchangeRateResponse = localApi.getExchangeRate(originCurrency, finalCurrency)
                            .onErrorResumeNext(throwable -> Single.error(new IOException("Error")))
                            .map(rate -> repository.save(ExchangeRateAssembler.toRequestDB(rate, finalCurrency)))
                            .map(ExchangeRateAssembler::toResponse).blockingGet();
                    singleEmitter.onSuccess(exchangeRateResponse);
                }));*/
        return null;
    }

    @Override
    public void getCountChain(String chain) {
        String result = chain;
        String[] arr = result.split(" ");

        for(int i=0; i< arr.length; i++)
        {
            if(arr[i].equals(arr[i-1]))
            System.out.println(arr[i]);
        }
    }

}
