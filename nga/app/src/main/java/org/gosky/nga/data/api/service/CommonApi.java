package org.gosky.nga.data.api.service;


import com.google.gson.JsonObject;

import org.gosky.nga.data.entity.BoardBean;
import org.gosky.nga.data.entity.TopicBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface CommonApi {

    /**
     * 获取验证码
     */
    @Headers({
            "cache-control:no-cache",
            "referer:https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui"
    })
    @GET("https://bbs.nga.cn/login_check_code.php")
    Observable<ResponseBody> getImageValidCode(@Query("id") String id);


    @Headers({
            "referer:https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui",
            "accept-encoding:gzip, deflate, br",
            "accept-language:zh-CN,zh;q=0.8"
    })
    @POST("https://bbs.nga.cn/nuke.php?__lib=login&__act=login&raw=3")
    @FormUrlEncoded
    Observable<ResponseBody> login(@Field(encoded = true, value = "name") String name, @Field("type") String type, @Field("password") String password,
                                   @Field("rid") String rid, @Field("captcha") String captcha);

    @Headers({
            "referer:https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui",
            "accept-encoding:gzip, deflate, br",
            "accept-language:zh-CN,zh;q=0.8"
    })
    @POST("https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui%2Fnuke.php%3F__lib%3Dlogin&__act=set_cookie&nojump=1&raw=3&to=https%3A%2F%2Fbbs.nga.cn%2Fnuke.php%3F__lib%3Dlogin%26__act%3Dset_cookie_complete%26raw%3D3")
    @FormUrlEncoded
    Observable<ResponseBody> getCookie(@Field("uid") int uid, @Field("cid") String cid);

    @GET
    Observable<ResponseBody> setCookie(@Url String url);

    /**
     * 获取帖子列表
     *
     * @param fid
     * @param page
     * @return
     */
    @GET("http://nga.178.com/thread.php?lite=js&noprefix")
    Observable<JsonObject> getThreads(@Query("fid") String fid, @Query("page") String page);


    /**
     *  获取帖子详情
     * @param tid
     * @param page
     * @return
     */
    @GET("http://bbs.nga.cn/read.php?lite=js&noprefix&v2")
    Observable<TopicBean> getTopic(@Query("tid") String tid, @Query("page") String page);


    /**
     *  获取首页模板
     * @return
     */
    @GET("http://bbs.nga.cn/app_api.php?__lib=home&__act=category&")
    Observable<BoardBean> getBoard();
}
