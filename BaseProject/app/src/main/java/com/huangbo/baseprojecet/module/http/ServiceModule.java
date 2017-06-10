package com.huangbo.baseprojecet.module.http;

import com.huangbo.baseprojecet.http.RetrofitBuilder;
import com.huangbo.baseprojecet.http.ApiServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangb on 2017/5/10.
 */

@Module
public class ServiceModule {

    @Singleton
    @Provides
    public ApiServices proidverIPLocationServiceModule(RetrofitBuilder retrofit) {
        return retrofit.getRetrofit().create(ApiServices.class);
    }
}
