package com.huangbo.baseprojecet.module.activity;

import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.sconp.MainSconp;
import com.huangbo.baseprojecet.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangb on 2017/5/11.
 */

@Module
public class MainModule {

    private MainView<LocationBean> mainView;

    public MainModule(MainView<LocationBean> mainView) {
        this.mainView = mainView;
    }

    @MainSconp
    @Provides
    MainView<LocationBean> ProbidesTest() {
        return mainView;
    }
}
