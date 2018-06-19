package org.gosky.nga.main

import android.app.Application
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.util.Log
import okhttp3.ResponseBody
import org.gosky.base.data.NGAService
import org.gosky.nga.App
import org.gosky.nga.base.ObservableViewModel
import org.gosky.nga.data.local.AppDatabase
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by guo on 2018/4/13.
 * desc:
 */
class MainViewModel(context: Application) : ObservableViewModel(context), KoinComponent {
    private val TAG = "MainViewModel";
    val model = ObservableField<MainForumEntity>()
    val title = ObservableArrayList<Result>()
    private val service: NGAService by inject()
    val user = AppDatabase.getInstance(App.getInstance()).userDao().getUser()


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
        service.getThreads("-7")
                .enqueue(object: Callback<ResponseBody?> {
                    override fun onFailure(call: Call<ResponseBody?>?, t: Throwable?) {
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>?) {
                        println(response?.body())
                    }
                })
    }

}