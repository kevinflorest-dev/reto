package com.example.demo.repository;

import com.example.demo.model.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findByOriginCurrencyAndFinalCurrency(String originCurrency, String finalCurrency);

}
