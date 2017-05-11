package com.huangbo.baseprojecet.compoment;

import com.huangbo.baseprojecet.TestActiviyu;
import com.huangbo.baseprojecet.module.TestModule;
import com.huangbo.baseprojecet.module.http.HttpClientModule;
import com.huangbo.baseprojecet.module.http.RetrofitModule;
import com.huangbo.baseprojecet.module.http.ServiceModule;
import com.huangbo.baseprojecet.module.modle.TestModleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huangb on 2017/5/10.
 * 单独Test 页面组件
 */

@Singleton
@Component(modules = {HttpClientModule.class,
        RetrofitModule.class,
        ServiceModule.class,
        TestModule.class,
        TestModleModule.class})
public interface TestComponent {
    void inject(TestActiviyu testActiviyu);
}
