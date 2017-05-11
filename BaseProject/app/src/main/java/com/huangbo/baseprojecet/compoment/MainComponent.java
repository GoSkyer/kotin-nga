package com.huangbo.baseprojecet.compoment;

import com.huangbo.baseprojecet.MainActivity;
import com.huangbo.baseprojecet.module.activity.MainModule;
import com.huangbo.baseprojecet.module.modle.MainModleModule;
import com.huangbo.baseprojecet.sconp.MainSconp;

import dagger.Subcomponent;

/**
 * Created by huangb on 2017/5/11.
 */
@MainSconp
@Subcomponent(modules = {MainModule.class,
        MainModleModule.class
})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
