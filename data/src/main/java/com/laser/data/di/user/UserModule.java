package com.laser.data.di.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laser.data.net.ApiEndpoints;
import com.laser.data.net.LoggingInterceptor;
import com.laser.whoopet.data.BuildConfig;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class UserModule {
//    @Provides
//    ApiEndpoints provideEndpoints() {
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                .create();
//
//        OkHttpClient client = new OkHttpClient();
//        client.setConnectTimeout(10, TimeUnit.SECONDS);
//        client.interceptors().add(new LoggingInterceptor());
//
//        return new Retrofit.Builder()
//                .baseUrl(BuildConfig.SERVER_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build()
//                .create(ApiEndpoints.class);
//    }
}
