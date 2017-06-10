package com.huangbo.baseprojecet.module.modle;

import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.ApiServices;
import com.huangbo.baseprojecet.impl.TestModleImple;
import com.huangbo.baseprojecet.view.TestView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangb on 2017/5/11.
 */

@Module
public class TestModleModule {

    @Singleton
    @Provides
    TestModleImple ProbidesTest(ApiServices mService, TestView<LocationBean> mView) {
        return new TestModleImple(mService, mView);
    }
}
