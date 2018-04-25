package org.gosky.nga

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

/**
 * Created by zohar on 2018/4/25.
 * desc:
 */
class App : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
//        import(kodeinModule)
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        private lateinit var app:App
        fun getInstance() = app
    }
}