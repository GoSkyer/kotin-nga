package com.huangbo.baseprojecet.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huangb on 2017/5/9.
 * retrofit 类
 */

public class MineRetrofit {
    private static final String BASE_URL = "http://bbs.nga.cn/";
    private static volatile Retrofit retrofit;

    public MineRetrofit(OkHttpClient okHttpClient) {
        if (retrofit == null) {
            synchronized (this) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okHttpClient)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }
}
