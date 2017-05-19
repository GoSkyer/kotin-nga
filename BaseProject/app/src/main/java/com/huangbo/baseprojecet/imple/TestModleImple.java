package com.huangbo.baseprojecet.imple;

import android.util.Log;

import com.huangbo.baseprojecet.base.BaseModleImple;
import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.MineService;
import com.huangbo.baseprojecet.modle.TestModle;
import com.huangbo.baseprojecet.view.TestView;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by huangb on 2017/5/11.
 */

public class TestModleImple extends BaseModleImple<TestView<LocationBean>> implements TestModle{

    @Inject
    public TestModleImple(MineService mService, TestView mView) {
        super(mService, mView);
    }

    @Override
    public void getIpInfo(String ip) {
        addSubscription(mService.getIPInfo(), new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
//                mView.success(new LocationBean());
                e.printStackTrace();
            }

            @Override
            public void onNext(String taobaoIPLocationInfo) {
                Log.i(getClass().getName(),taobaoIPLocationInfo);
            }

        });
    }

}
