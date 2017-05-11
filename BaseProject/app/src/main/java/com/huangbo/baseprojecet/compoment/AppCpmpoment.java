package com.huangbo.baseprojecet.compoment;


import com.huangbo.baseprojecet.module.AppModule;
import com.huangbo.baseprojecet.module.activity.MainModule;
import com.huangbo.baseprojecet.module.http.HttpClientModule;
import com.huangbo.baseprojecet.module.http.RetrofitModule;
import com.huangbo.baseprojecet.module.http.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huangb on 2017/5/9.
 * app 组件
 */

@Singleton
@Component(modules = {AppModule.class,
        HttpClientModule.class,
        RetrofitModule.class,
        ServiceModule.class})
public interface AppCpmpoment {


    MainComponent setUp(MainModule mainModle);
}
