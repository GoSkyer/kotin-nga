package com.huangbo.baseprojecet;

import android.app.Application;
import android.content.Context;

import com.huangbo.baseprojecet.compoment.AppCpmpoment;
import com.huangbo.baseprojecet.compoment.DaggerAppCpmpoment;
import com.huangbo.baseprojecet.module.AppModule;

/**
 * Created by huangb on 2017/5/9.
 */

public class App extends Application {

    private static volatile AppCpmpoment mAppCpmpoment;
    public static volatile App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }


    public static App get() {
        return instance;
    }


    public AppCpmpoment getAppComponent() {
        if (mAppCpmpoment == null) {
            synchronized (this) {
                if (mAppCpmpoment == null)
                    mAppCpmpoment = DaggerAppCpmpoment
                            .builder()
                            .appModule(new AppModule(this))
                            .build();
            }
        }
        return mAppCpmpoment;
    }
}
