package com.huangbo.baseprojecet.imple;

import com.huangbo.baseprojecet.base.BaseModleImple;
import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.http.MineService;
import com.huangbo.baseprojecet.modle.TestModle;
import com.huangbo.baseprojecet.view.TestView;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
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
        addSubscription(mService.getIPInfo(), new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
//                mView.success(new LocationBean());
                e.printStackTrace();
            }

            @Override
            public void onNext(ResponseBody taobaoIPLocationInfo) {
                try {
//                    String string = taobaoIPLocationInfo.string();
                    String gbk = new String(taobaoIPLocationInfo.bytes(), "GBK");
                    String s = new String(gbk.getBytes("UTF-8"), "UTF-8");
                    System.out.println(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }

}
