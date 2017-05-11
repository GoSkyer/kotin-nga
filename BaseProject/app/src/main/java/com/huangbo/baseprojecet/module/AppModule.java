package com.huangbo.baseprojecet.module;

import android.content.Context;

import com.huangbo.baseprojecet.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangb on 2017/5/9.
 */

@Module
public class AppModule {
    private Context context;

    public AppModule(App context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context ProviderAppContext() {
        return context;
    }
}
