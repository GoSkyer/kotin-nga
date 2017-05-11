package com.huangbo.baseprojecet.module.modle;

import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.MineService;
import com.huangbo.baseprojecet.imple.TestModleImple;
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
    TestModleImple ProbidesTest(MineService mService, TestView<LocationBean> mView) {
        return new TestModleImple(mService, mView);
    }
}
