package org.gosky.base.di.module;

import android.app.Activity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Module;
import dagger.Provides;

/**
 * @author guozhong
 * @date 2017/6/23
 */

@Module
public class ActivityModule {
    private Activity activity;


    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public RxPermissions provideRxPermissions(){
        return new RxPermissions(activity);
    }
}
