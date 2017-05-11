package com.huangbo.baseprojecet.module.http;

import com.huangbo.baseprojecet.http.MineRetrofit;
import com.huangbo.baseprojecet.http.MineService;

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
    public MineService proidverIPLocationServiceModule(MineRetrofit retrofit) {
        return retrofit.getRetrofit().create(MineService.class);
    }
}
