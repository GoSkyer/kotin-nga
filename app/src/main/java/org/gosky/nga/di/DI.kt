package org.gosky.base.di

import org.gosky.base.data.NGAService
import org.gosky.base.data.RetrofitBuilder
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

/**
 * Created by zohar on 2018/4/25.
 * desc:
 */
val kodeinModule = Kodein {
    bind<NGAService>() with singleton { RetrofitBuilder().createService() }
}