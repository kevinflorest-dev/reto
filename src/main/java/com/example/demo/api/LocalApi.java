package com.example.demo.api;

import com.example.demo.model.dao.LocalApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocalApi {

    @GET("/fixer/latest")
    Single<LocalApiResponse> getExchangeRate(@Query("base") String base,
                                             @Query("symbols") String symbols);
}
