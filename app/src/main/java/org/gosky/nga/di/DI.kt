package org.gosky.base.di

import org.gosky.nga.App
import org.gosky.nga.data.local.AppDatabase
import org.gosky.nga.data.remote.RetrofitBuilder
import org.gosky.nga.main.MainViewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by zohar on 2018/4/25.
 * desc:
 */
val myModule : Module = applicationContext {
    bean {
        RetrofitBuilder().createService()
    }

    bean {
        MainViewModel(get())

    }

    bean {
        AppDatabase.getInstance(App.getInstance()).userDao()
    }

}