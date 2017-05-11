package com.huangbo.baseprojecet.persenter;

import com.huangbo.baseprojecet.base.BasePersenter;
import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.MineService;
import com.huangbo.baseprojecet.imple.TestModleImple;
import com.huangbo.baseprojecet.view.TestView;

import javax.inject.Inject;

/**
 * Created by huangb on 2017/5/10.
 */

public class TestPersenter extends BasePersenter<TestView<LocationBean>, TestModleImple> {

    @Inject
    public TestPersenter(MineService mService, TestView<LocationBean> mView, TestModleImple mModuleImpl) {
        super(mService, mView, mModuleImpl);
    }


    public void mai() {
        mModuleImpl.getIpInfo("116.228.89.150");

    }
}
