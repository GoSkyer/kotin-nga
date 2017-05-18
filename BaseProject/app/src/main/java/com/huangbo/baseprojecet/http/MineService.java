package com.huangbo.baseprojecet.http;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by huangb on 2017/5/9.
 * 接口类
 */

public interface MineService {

    @GET("/thread.php?fid=-7&page=1&lite=js&noprefix")
    @Headers({
            "Accept-Charset:GBK",
            "Accept-Encoding:gzip,deflate",
            "Cookie:ngaPassportUid=25944452; ngaPassportCid=657deaca89e6ae797c2078f9a6116c69dae1c139",
            "User-Agent:Nga_Official/573([LGE LG-F500L];Android5.1)"
    })
    Observable<Object> getIPInfo();
}