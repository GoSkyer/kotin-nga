package com.huangbo.baseprojecet.module.modle;

import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.ApiServices;
import com.huangbo.baseprojecet.impl.MainModleImp;
import com.huangbo.baseprojecet.sconp.MainSconp;
import com.huangbo.baseprojecet.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangb on 2017/5/11.
 */

@Module
public class MainModleModule {


    @MainSconp
    @Provides
    MainModleImp MainModleModule(ApiServices mService, MainView<LocationBean> mView) {
        return new MainModleImp(mService, mView);
    }
}
