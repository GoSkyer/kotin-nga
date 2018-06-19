package org.gosky.nga.data.remote

import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import org.gosky.nga.data.local.UserDao
import org.gosky.nga.util.Sign
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * Created by guo on 2018/6/19.
 * desc:
 */
class ParamsInterceptor : Interceptor, KoinComponent {
    private val userDao by inject<UserDao>()

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (request.method() == "POST") {
            if (request.body() is FormBody) {
                val bodyBuilder = FormBody.Builder()
                val formBody = request.body() as FormBody
                val params = mutableMapOf<String, String>()
                for (i in 0 until formBody.size()) {
                    bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i))
                    if (formBody.encodedName(i) != "page" && formBody.encodedName(i) != "stid")
                        params.put(formBody.encodedName(i), formBody.encodedValue(i))
                }

//                launch(UI) {
//                    val deferred = async(CommonPool) {
                val t = (System.currentTimeMillis() / 1000).toString()
                bodyBuilder
                        .addEncoded("t", t)
                        .addEncoded("app_id", "1010")

                val user = userDao.getUserSync()
                if (user != null) {
                    bodyBuilder
                            .addEncoded("access_token", user.token)
                            .addEncoded("access_uid", user.uid.toString())


                    val sign = Sign.getInstance().sign(user.uid.toString(), user.token, t, params.values.toTypedArray())
                    bodyBuilder.add("sign", sign)
                }


//                    }

                request = request.newBuilder().post(bodyBuilder.build()).build()
//                }
            }
        }
        return chain.proceed(request)
    }
}