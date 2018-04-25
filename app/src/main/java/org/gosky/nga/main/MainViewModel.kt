package org.gosky.nga.main

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.util.Log
import org.gosky.base.data.NGAService
import org.gosky.nga.App
import org.kodein.di.generic.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by guo on 2018/4/13.
 * desc:
 */
class MainViewModel : BaseObservable() {
    private val TAG = "MainViewModel";
    var model = ObservableField<MainForumEntity>()
    var title = ObservableArrayList<Result>()
    private val service: NGAService by App.getInstance().kodein.instance()

    fun getData() {

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