package com.huangbo.baseprojecet.module.http;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by huangb on 2017/5/10.
 */

@Module
public class HttpClientModule {

    private static volatile OkHttpClient mKOkHttpClient;


    @Singleton
    @Provides
    @Named("default")
    OkHttpClient priOkHttpClient() {
        if (mKOkHttpClient == null) {
            synchronized (this) {
                if (mKOkHttpClient == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    mKOkHttpClient = new OkHttpClient.Builder()
                            .addNetworkInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .build();
                }
            }

        }
        return mKOkHttpClient;
    }
}
