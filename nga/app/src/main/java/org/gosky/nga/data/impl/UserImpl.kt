package org.gosky.nga.data.impl

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.reactivex.Observable
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.api.service.CommonApi
import org.gosky.nga.data.entity.LoginBean
import org.jsoup.Jsoup
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/7/19
 */
class UserImpl @Inject constructor(private val commonApi: CommonApi) {

    private val TAG = "UserImpl";

    fun login(name: String, password: String, captcha: String, rid: String): Observable<LoginBean> {
        return commonApi.login(name, "name", password, rid, captcha)
                .compose(RxHelper.rxSchedulerHelper())
                .map { it.string() }
                .map { Jsoup.parse(it).body().data() }
                .map { it.replace("window.script_muti_get_var_store=", "") }
                .map {
                    val asJsonObject = JsonParser().parse(it).asJsonObject
                    when {
                        asJsonObject.has("error") ->
                            throw RuntimeException(asJsonObject.getAsJsonObject("error").get("0").asString)
                        asJsonObject.has("data") -> {
                            val fromJson = Gson().fromJson(asJsonObject.get("data").toString(), LoginBean::class.java)
                            return@map fromJson
                        }
                        else ->
                            throw RuntimeException("未知返回结果")
                    }
                }

    }

    fun getCookie(uid: Int, cid: String): Observable<JsonObject>? {
        return commonApi.getCookie(uid, cid)
                .compose(RxHelper.rxSchedulerHelper())
                .map {
                    Jsoup.parse(it.string()).body().data()
                            .replace("window.script_muti_get_var_store=", "")
                }
                .map {
                    val j: JsonObject = JsonParser().parse(it).getAsJsonObject()
                    when {
                        j.has("error") ->
                            throw RuntimeException(j.getAsJsonObject("error").get("0").asString)
                        j.has("data") -> {
                            return@map j.getAsJsonObject("data")
                        }
                        else ->
                            throw RuntimeException("未知返回结果")
                    }
                }
    }

    fun setCookie(url1: String, url2: String, url3: String) {
        Observable.merge(commonApi.setCookie(url1),
                commonApi.setCookie(url2),
                commonApi.setCookie(url3))
                .compose(RxHelper.rxSchedulerHelper())
                .subscribe({
                    Log.i(TAG, ": login success")
                }, { it.printStackTrace() })

    }

}