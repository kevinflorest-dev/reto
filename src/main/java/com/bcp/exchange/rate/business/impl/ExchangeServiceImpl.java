package com.bcp.exchange.rate.business.impl;

import com.bcp.exchange.rate.api.LocalApi;
import com.bcp.exchange.rate.business.ExchangeService;
import com.bcp.exchange.rate.model.assembler.ExchangeAssembler;
import com.bcp.exchange.rate.model.dao.response.ExchangeRateResponse;
import com.bcp.exchange.rate.model.entity.ExchangeRate;
import com.bcp.exchange.rate.repository.ExchangeRepository;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

@Slf4j
@Service
public class ExchangeServiceImpl implements ExchangeService {

    private LocalApi localApi;
    @Autowired
    private ExchangeRepository repository;


    ExchangeServiceImpl() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        localApi = retrofit.create(LocalApi.class);
    }

    @Override
    public Single<ExchangeRateResponse> getExchangeRate(String origin, String destination) {
        return Single.create(singleEmitter -> repository.findByOriginCurrencyAndFinalCurrency(origin,destination)
                .ifPresentOrElse(obj -> {
                    ExchangeRateResponse response = ExchangeAssembler.toResponse(obj);
                    log.info("Se encontró en base de datos.");
                    singleEmitter.onSuccess(response);
                }, () -> {
                    log.info("Se procede a consultar api local.");
                    ExchangeRate bd = localApi.getActuallyCurrency(origin,destination)
                            .onErrorResumeNext(throwable -> Single.error(new EntityNotFoundException("Error al consultar api local")))
                            .map(api -> {
                                ExchangeRate entity = ExchangeAssembler.localApiToEntity(destination,api);
                                repository.save(entity);
                                log.info("Se guardó en base datos.");
                                return entity;
                            }).blockingGet();
                    ExchangeRateResponse response = ExchangeAssembler.toResponse(bd);
                    singleEmitter.onSuccess(response);
                }));
    }

    @Override
    public Observable<ExchangeRateResponse> getAllExchangeRate() {
        return Observable.fromIterable(repository.findAll())
                .onErrorResumeNext(Observable.error(new SQLException("Error al consultar la bd")))
                .map(ExchangeAssembler::toResponse);
    }

    @Override
    public void getMatrizByValue(String userValue) {

        try {
        System.out.println ("Empezamos el programa");

        //System.out.println ("Por favor introduzca valor del usuario:");

        //String entradaTeclado = "";

        // entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        //entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner

        Integer value = Integer.parseInt(userValue);

        //System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");

            for (int j = 1; j < 11; j++) {
                int val1 = 0;
                for (int i = 1; i < 11; i++) {
                    int val2 = (value * i) + val1;
                    System.out.print(" [" + i + "][" + j + "]= ");
                    System.out.print(val2);
                    val1 = val2;
                }
                System.out.println("");
            }
        }catch (Exception e){
            log.error("Falló en crear la matriz");
        }
    }
}
