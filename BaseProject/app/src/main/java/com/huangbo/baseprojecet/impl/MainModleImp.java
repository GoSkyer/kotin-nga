package com.huangbo.baseprojecet.impl;

import com.huangbo.baseprojecet.base.BaseModleImple;
import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.ApiServices;
import com.huangbo.baseprojecet.modle.MainModle;
import com.huangbo.baseprojecet.view.MainView;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by huangb on 2017/5/11.
 */

public class MainModleImp extends BaseModleImple<MainView<LocationBean>> implements MainModle{
    @Inject
    public MainModleImp(ApiServices mService, MainView<LocationBean> mView) {
        super(mService, mView);
    }


    @Override
    public void getData(String ip) {
        addSubscription(mService.getIPInfo(), new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.success(new LocationBean());
                e.printStackTrace();
            }

            @Override
            public void onNext(ResponseBody  taobaoIPLocationInfo) {
                try {
//                    String string = taobaoIPLocationInfo.string();
                    String gbk = new String(taobaoIPLocationInfo.bytes(), "UTF-8");
                    System.out.println(gbk);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                mView.success(taobaoIPLocationInfo);
//                Toast.makeText(App.get(), taobaoIPLocationInfo.getData().toString(),Toast.LENGTH_SHORT).show();
            }

        });
    }
}
