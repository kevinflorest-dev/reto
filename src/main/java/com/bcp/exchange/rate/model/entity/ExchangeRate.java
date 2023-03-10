package com.bcp.exchange.rate.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String originCurrency;

    @Column
    private String finalCurrency;

    @Column(name = "date_rate")
    private String date;

    @Column(name = "value_rate")
    private String value;
}
