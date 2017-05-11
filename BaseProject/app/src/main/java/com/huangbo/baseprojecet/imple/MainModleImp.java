package com.huangbo.baseprojecet.imple;

import android.widget.Toast;

import com.huangbo.baseprojecet.App;
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
        addSubscription(mService.getIPInfo(ip), new Subscriber<LocationBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.success(new LocationBean());
            }

            @Override
            public void onNext(LocationBean taobaoIPLocationInfo) {
                mView.success(taobaoIPLocationInfo);
                Toast.makeText(App.get(), taobaoIPLocationInfo.getData().toString(),Toast.LENGTH_SHORT).show();
            }

        });
    }
}
