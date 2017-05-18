package com.huangbo.baseprojecet.imple;

import com.huangbo.baseprojecet.base.BaseModleImple;
import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.MineService;
import com.huangbo.baseprojecet.modle.MainModle;
import com.huangbo.baseprojecet.view.MainView;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by huangb on 2017/5/11.
 */

public class MainModleImp extends BaseModleImple<MainView<LocationBean>> implements MainModle{
    @Inject
    public MainModleImp(MineService mService, MainView<LocationBean> mView) {
        super(mService, mView);
    }


    @Override
    public void getData(String ip) {
        addSubscription(mService.getIPInfo(), new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.success(new LocationBean());
                e.printStackTrace();
            }

            @Override
            public void onNext(Object taobaoIPLocationInfo) {
                System.out.println(taobaoIPLocationInfo.toString());
//                mView.success(taobaoIPLocationInfo);
//                Toast.makeText(App.get(), taobaoIPLocationInfo.getData().toString(),Toast.LENGTH_SHORT).show();
            }

        });
    }
}
