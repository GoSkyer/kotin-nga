package org.gosky.nga.data.impl

import android.util.Log
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.api.service.CommonApi
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
                .subscribe { Log.d(TAG, ": " + it.string()) }

    }
}