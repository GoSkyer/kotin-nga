package org.gosky.nga.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.gosky.base.data.NGAService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by guo on 2018/4/25.
 * desc:
 */
class RetrofitBuilder {
    private fun create(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://bbs.nga.cn/")
                .client(createOkHttpClient())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    fun createService(): NGAService {
        return create().create<NGAService>(NGAService::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ParamsInterceptor())
                .addInterceptor(okHttpLogger())
                .build()
    }

    private fun okHttpLogger(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging;
    }
}