package com.huangbo.baseprojecet.module.http;

import com.huangbo.baseprojecet.http.MineRetrofit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by huangb on 2017/5/10.
 */

@Module
public class RetrofitModule {


    @Singleton
    @Provides
    MineRetrofit ProvidesRetrofit(@Named("default") OkHttpClient okHttpClient){
        return new MineRetrofit(okHttpClient);
    }
}
