package com.huangbo.baseprojecet.module.http;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by huangb on 2017/5/10.
 */

@Module
public class HttpClientModule {

    private static volatile OkHttpClient mKOkHttpClient;


    @Singleton
    @Provides
    @Named("default")
    OkHttpClient priOkHttpClient() {
        if (mKOkHttpClient == null) {
            synchronized (this) {
                if (mKOkHttpClient == null) {
                    mKOkHttpClient = new OkHttpClient.Builder()
                            .addNetworkInterceptor(new LogInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .build();
                }
            }

        }
        return mKOkHttpClient;
    }


    /**
     * LOG
     */
    public static class LogInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
//            Logger.e("request:" + request.toString());
            long t1 = System.nanoTime();
            Response response = chain.proceed(chain.request());
            long t2 = System.nanoTime();
            Logger.e(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Logger.e(content);
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
                    .build();
        }
    }
}
