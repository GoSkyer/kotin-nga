package org.gosky.nga

import android.app.Application
import org.gosky.base.di.myModule
import org.koin.android.ext.android.startKoin



/**
 * Created by zohar on 2018/4/25.
 * desc:
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        app = this
        startKoin(this, listOf(myModule))
//        SpiderMan.getInstance()
//                .init(this)
//                //设置是否捕获异常，不弹出崩溃框
//                .setEnable(true)
//                //设置是否显示崩溃信息展示页面
//                .showCrashMessage(true)
//                //是否回调异常信息，友盟等第三方崩溃信息收集平台会用到,
//                .setOnCrashListener { t, ex, model ->
//                    //CrashModel 崩溃信息记录，包含设备信息
//                }
    }

    companion object {
        private lateinit var app:App
        fun getInstance() = app
    }
}