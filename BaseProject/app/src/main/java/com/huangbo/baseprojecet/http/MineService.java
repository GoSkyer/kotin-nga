package com.huangbo.baseprojecet.http;

import com.huangbo.baseprojecet.bean.LocationBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by huangb on 2017/5/9.
 * 接口类
 */

public interface MineService {

    @GET("/service/getIpInfo2.php")
    Observable<LocationBean> getIPInfo(@Query("ip") String ip);
}
