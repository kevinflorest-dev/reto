package com.example.demo.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Setter
@Getter
@Builder
public class ExchangeRate {

    @Id
    @GeneratedValue
    Long id;

    @Column
    private String originCurrency;

    @Column
    private String finalCurrency;

    @Column
    private String date;

    @Column
    private String value;

}
