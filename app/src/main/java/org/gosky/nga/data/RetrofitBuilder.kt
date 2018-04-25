package org.gosky.base.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by guo on 2018/4/25.
 * desc:
 */
class RetrofitBuilder {
    fun create(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://bbs.nga.cn/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    fun createService(): NGAService {
        return create().create<NGAService>(NGAService::class.java)
    }
}