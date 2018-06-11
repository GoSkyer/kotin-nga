package org.gosky.base.di

import com.squareup.moshi.Moshi
import org.gosky.base.data.RetrofitBuilder
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
        MainViewModel()

    }

    bean {

    }

}