package org.gosky.base.data

import okhttp3.ResponseBody
import org.gosky.nga.main.MainForumEntity
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface NGAService {

    @GET("http://bbs.ngacn.cc/app_api.php?__lib=home&__act=category&")
    fun appApi(): Call<MainForumEntity>


    @POST("http://bbs.ngacn.cc/app_api.php?__lib=subject&__act=list&")
    @FormUrlEncoded
    fun getThreads(@Field("fid") fid: String): Call<ResponseBody>


}