package com.bcp.exchange.rate.api;

import com.bcp.exchange.rate.model.dao.api.LocalApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LocalApi {

    @GET("/fixer/latest")
    Single<LocalApiResponse> getActuallyCurrency(@Query("base") String base,
                                                 @Query("symbols") String symbols);

}
