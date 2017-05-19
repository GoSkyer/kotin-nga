package com.huangbo.baseprojecet.module.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.GzipSource;
import okio.Okio;

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
                            .addInterceptor(new Gbk2utf8Interceptor())
                            .addInterceptor(new UnzippingInterceptor())
                            .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .retryOnConnectionFailure(true)
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .build();
                }
            }

        }
        return mKOkHttpClient;
    }


    private class UnzippingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            return unzip(response);
        }
    }

    private Response unzip(final Response response) throws IOException {

        if (response.body() == null) {
            return response;
        }

        GzipSource responseBody = new GzipSource(response.body().source());
        Headers strippedHeaders = response.headers().newBuilder()
                .removeAll("Content-Encoding")
                .removeAll("Content-Length")
                .build();
        return response.newBuilder()
                .headers(strippedHeaders)
                .body(new RealResponseBody(strippedHeaders, Okio.buffer(responseBody)))
                .build();
    }


    private class Gbk2utf8Interceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            return gbk2utf8(response);
        }
    }

    private Response gbk2utf8(Response response) throws IOException {
        if (response.body() == null)
            return response;
        InputStream in = response.body().byteStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));
//        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        String s = sb.toString();
        Log.d("okhttp", s);
        ResponseBody responseBody = response.body();
        MediaType contentType = responseBody.contentType();
        ResponseBody body = ResponseBody.create(contentType, s);
        return response.newBuilder()
                .body(body)
                .build();
    }

}
