package org.gosky.nga.data.impl

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.Single
import org.gosky.nga.common.config.DataConfig
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.api.service.CommonApi
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.data.entity.ThreadBean
import org.gosky.nga.data.entity.TopicBean
import javax.inject.Inject


/**
 * @author guozhong
 * *
 * @date 2017/6/23
 */

class ThreadImpl @Inject
constructor(private val apiManager: CommonApi) {
    val TAG = "ThreadImpl"

    fun getThreads(fid: String, page: String): Single<MutableList<ThreadBean>> {
        return apiManager
                .getThreads(fid, page)
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


    fun getTopic(tid: String, page: String): Observable<TopicBean> {
        return apiManager
                .getTopic(tid, page)
                .flatMap {
                    if (it.data.__T != null && it.data.__T.quote_from != null) {
                        val quote_from = it.data.__T.quote_from
                        return@flatMap apiManager
                                .getTopic(quote_from.toString(), page)
                    } else {
                        return@flatMap Observable.just(it)
                    }
                }
    }

    fun getBoard(): Observable<BoardBean> {
        return apiManager.getBoard();
    }

    fun test() {
//        val type = object : TypeToken<Map<String, ThreadBean>>() {}.type
//        val fromJson = Gson().fromJson<Map<String, ThreadBean>>(DataConfig.str, type)

        try {
            val fromJson = Gson().fromJson(DataConfig.topic, TopicBean::class.java)
            Log.i(TAG, ": test" + fromJson);
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }


}
