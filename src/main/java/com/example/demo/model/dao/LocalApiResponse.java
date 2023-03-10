package com.example.demo.model.dao;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalApiResponse {

    private boolean flag;
    private Long timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;

}
