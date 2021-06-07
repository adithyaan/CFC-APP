package com.cfc.immortals.httpclient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit,tokenRetrofit, tempTokenRetrofit;
    private static final String BASE_URL = "";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request authorisedRequest = chain.request().newBuilder()
                                .addHeader("x-api-key", "APP-API-KEY").build();
                        return chain.proceed(authorisedRequest);
                    }).build();
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(defaultHttpClient)
                    .build();
        }
        return retrofit;
    }
}
