package org.gosky.base.data

import org.gosky.nga.main.MainForumEntity
import retrofit2.Call
import retrofit2.http.GET

interface NGAService {

    @GET("http://bbs.nga.cn/app_api.php?__lib=home&__act=category&")
    fun appApi(): Call<MainForumEntity>

}