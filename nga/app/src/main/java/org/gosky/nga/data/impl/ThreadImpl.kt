package org.gosky.nga.data.impl

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.Single
import org.gosky.nga.common.config.DataConfig
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.api.service.ApiManager
import org.gosky.nga.data.entity.ThreadBean
import javax.inject.Inject


/**
 * @author guozhong
 * *
 * @date 2017/6/23
 */

class ThreadImpl @Inject
constructor(private val apiManager: ApiManager) {
    val TAG = "ThreadImpl"
    fun getThreads(fid:String): Single<MutableList<ThreadBean>> {
        return apiManager.commonService
                .getThreads(fid, "1")
                .compose(RxHelper.rxSchedulerHelper<JsonObject>())
                .map {
                    val asJsonObject = it.getAsJsonObject("data")
                            .getAsJsonObject("__T")
                    Log.i(TAG, ": " + asJsonObject.size());
                    return@map asJsonObject
                }
                .map {
                    Log.i(TAG, ": it " + it.toString());
                    val fromJson = Gson().fromJson<Map<String, ThreadBean>>(it.toString(), object : TypeToken<Map<String, ThreadBean>>() {}.type)
                    Log.i(TAG, ": gson" + fromJson);
                    fromJson
                }
                .flatMap {
                    Log.i(TAG, ": flatMap");
                    Observable.fromIterable(it.entries)
                }
                .map { it.value }
                .toList()
    }

    fun test(){
        val type = object : TypeToken<Map<String, ThreadBean>>() {}.type
        val fromJson = Gson().fromJson<Map<String, ThreadBean>>(DataConfig.str, type)
        Log.i(TAG, ": gson" + fromJson);
    }

}
