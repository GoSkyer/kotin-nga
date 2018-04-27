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
    }

    companion object {
        private lateinit var app:App
        fun getInstance() = app
    }
}