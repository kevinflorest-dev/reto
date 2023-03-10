package com.bcp.exchange.rate;

import com.bcp.exchange.rate.business.impl.ExchangeServiceImpl;
import com.bcp.exchange.rate.model.dao.response.ExchangeRateResponse;
import com.bcp.exchange.rate.model.entity.ExchangeRate;
import com.bcp.exchange.rate.repository.ExchangeRepository;
import io.reactivex.Observable;
import io.reactivex.subscribers.TestSubscriber;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExchangeRateBcpApplicationTests {

	@InjectMocks
	private ExchangeServiceImpl service;

	@Mock
	private ExchangeRepository repository;


	@Test
	void findAll() {

		List<ExchangeRate> exchangeRates = new ArrayList<>();
		ExchangeRate exchangeRate = new ExchangeRate();
		exchangeRate.setDate("1");
		exchangeRate.setDate("1");
		exchangeRate.setFinalCurrency("1");
		exchangeRates.add(exchangeRate);

		List<ExchangeRateResponse> exchangeRateResponses = new ArrayList<>();
		ExchangeRateResponse response = new ExchangeRateResponse();
		response.setValue("1");
		response.setFinalCurrency("1");
		response.setOriginCurrency("1");
		response.setDate("1");
		exchangeRateResponses.add(response);

		Mockito.when(repository.findAll()).thenReturn(exchangeRates);

		TestSubscriber<ExchangeRateResponse> subscriber = new TestSubscriber<>();

		Observable<ExchangeRateResponse> observable = service.getAllExchangeRate();

		observable.subscribe();

		subscriber.assertNoErrors();
	}

	@Test
	void matriz(){
		service.getMatrizByValue("1");
	}

	@Test
	void matriz_with_error(){
		service.getMatrizByValue("ABC");
	}

}
