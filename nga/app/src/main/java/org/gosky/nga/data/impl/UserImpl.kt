package org.gosky.nga.data.impl

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParser
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

    fun login(name: String, password: String, captcha: String, rid: String) {
        commonApi.login(name, "name", password, rid, captcha)
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
                .subscribe({ Log.d(TAG, it.toString()) }
                        , { it.printStackTrace() })

    }
}