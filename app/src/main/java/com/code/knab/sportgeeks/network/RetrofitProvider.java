package com.code.knab.sportgeeks.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {

    private Retrofit retrofit;

    public RetrofitProvider() {
        this.retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://145.239.81.249:8080")
                .addConverterFactory(GsonConverterFactory.create(makeAGSON()))
                .client(prepareOkHttpClient())
                .build();;

    }

    private Gson makeAGSON() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    private OkHttpClient prepareOkHttpClient() {

        OkHttpClient.Builder http = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);

        HttpLoggingInterceptor.Logger myLogger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("CAR_APP", message);
            }
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(myLogger);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        http.addInterceptor(loggingInterceptor);

        return http.build();
    }

    public Retrofit getRetrofit() { return this.retrofit; }
}
