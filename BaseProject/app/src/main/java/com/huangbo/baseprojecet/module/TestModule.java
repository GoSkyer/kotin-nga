package com.huangbo.baseprojecet.module;

import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.view.TestView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangb on 2017/5/10.
 */

@Module
public class TestModule {

    private TestView<LocationBean> mainView;

    public TestModule(TestView<LocationBean> mainView) {
        this.mainView = mainView;
    }

    @Singleton
    @Provides
    TestView<LocationBean> ProbidesTest() {
        return mainView;
    }
}
