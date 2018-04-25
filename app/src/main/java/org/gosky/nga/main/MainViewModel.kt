package org.gosky.nga.main

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.util.Log
import org.gosky.base.data.NGAService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by guo on 2018/4/13.
 * desc:
 */
class MainViewModel : BaseObservable() {
    private val TAG = "MainViewModel";
    var model = ObservableField<MainForumEntity>()
    var title = ObservableArrayList<Result>()

    fun getData() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://bbs.nga.cn/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        val service = retrofit.create<NGAService>(NGAService::class.java)
        service.appApi()
                .enqueue(object : Callback<MainForumEntity> {
                    override fun onResponse(call: Call<MainForumEntity>?, response: Response<MainForumEntity>?) {
                        model.set(response?.body())
                        Log.d(TAG, ": " + response?.body().toString());
                    }

                    override fun onFailure(call: Call<MainForumEntity>?, t: Throwable?) {
                        t?.printStackTrace()
                    }

                })
    }

}