package com.huangbo.baseprojecet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.huangbo.baseprojecet.base.BasePersenterActivity;
import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.compoment.DaggerTestComponent;
import com.huangbo.baseprojecet.module.TestModule;
import com.huangbo.baseprojecet.persenter.TestPersenter;
import com.huangbo.baseprojecet.view.TestView;

/**
 * Created by huangb on 2017/5/10.
 */

public class TestActiviyu extends BasePersenterActivity<TestPersenter> implements TestView<LocationBean> {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerTestComponent.builder().testModule(new TestModule(this)).build().inject(this);
        mPersenter.mai();
    }


    @Override
    public void success(LocationBean taobaoIPLocationInfo) {
        Toast.makeText(this, "dasdasdas", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {

    }
}
