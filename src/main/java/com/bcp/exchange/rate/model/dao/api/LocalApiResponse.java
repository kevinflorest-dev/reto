package com.bcp.exchange.rate.model.dao.api;

import lombok.*;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalApiResponse {

    private boolean success;
    private Long timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;

}
