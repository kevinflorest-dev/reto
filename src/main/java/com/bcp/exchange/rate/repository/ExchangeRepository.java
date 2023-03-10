package com.bcp.exchange.rate.repository;

import com.bcp.exchange.rate.model.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findByOriginCurrencyAndFinalCurrency(String origin, String destination);


}
