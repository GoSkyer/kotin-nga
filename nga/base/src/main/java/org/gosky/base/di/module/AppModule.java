package org.gosky.base.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jess on 8/4/16.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    public Gson provideGson(){return new Gson();}

    @Singleton
    @Provides
    public RxPermissions provideRxPermissions(){
        return RxPermissions.getInstance(mApplication);
    }
}
