package org.gosky.nga.data.api.service;


import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;


public interface CommonApi {
    @GET("/thread.php?fid=-7&page=1&lite=js&noprefix")
    @Headers({
            "Accept-Charset:GBK",
            "Accept-Encoding:gzip,deflate",
            "Cookie:ngaPassportUid=25944452; ngaPassportCid=657deaca89e6ae797c2078f9a6116c69dae1c139",
            "User-Agent:Nga_Official/573([LGE LG-F500L];Android5.1)"
    })
    Observable<ResponseBody> getIPInfo();


    @GET("http://account.178.com/q_vcode.php?_act=gen_reg")
    Observable<ResponseBody> getImageValidCode();
}
