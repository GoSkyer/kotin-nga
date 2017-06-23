package org.gosky.nga.data.api.service;


import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface CommonApi {
    @GET("/thread.php?fid=-7&page=1&lite=js&noprefix")
    @Headers({
            "Accept-Charset:GBK",
            "Accept-Encoding:gzip,deflate",
            "Cookie:ngaPassportUid=25944452; ngaPassportCid=657deaca89e6ae797c2078f9a6116c69dae1c139",
            "User-Agent:Nga_Official/573([LGE LG-F500L];Android5.1)"
    })
    Observable<ResponseBody> getIPInfo();

    /**
     * 获取验证码
     *
     * @return
     */
    @GET("http://account.178.com/q_vcode.php?_act=gen_reg")
    Observable<ResponseBody> getImageValidCode();


    @GET("http://nga.178.com/thread.php?lite=js&noprefix")
    Observable<JsonObject> getThreads(@Query("fid") String fid, @Query("page") String page);
}
