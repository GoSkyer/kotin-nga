package org.gosky.base.di.module;

import android.app.Application;
import android.util.Log;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import org.gosky.base.base.BaseApplication;
import org.gosky.base.utils.DataHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.GzipSource;
import okio.Okio;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class ClientModule {
    private static final int TOME_OUT = 10;
    public static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;//缓存文件最大值为10Mb
    public HttpUrl mApiUrl;
    private static final String TAG = "ClientModule";

    public ClientModule(Buidler buidler) {
        this.mApiUrl = buidler.apiUrl;
    }

    public static Buidler buidler() {
        return new Buidler();
    }


    @Singleton
    @Provides
    public OkHttpClient provideClient(Cache cache, PersistentCookieJar cookieJar) {
        final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        return configureClient(okHttpClient, cache, cookieJar);
    }


    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client, HttpUrl httpUrl) {
        final Retrofit.Builder builder = new Retrofit.Builder();
        return configureRetrofit(builder, client, httpUrl);
    }

    @Singleton
    @Provides
    public HttpUrl provideBaseUrl() {
        return mApiUrl;
    }

    @Singleton
    @Provides
    public Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);//设置缓存路径和大小
    }

    @Singleton
    @Provides
    public PersistentCookieJar provideCookieJar(Application application) {
        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(BaseApplication.getContext()));
    }

    /**
     * 提供缓存地址
     */

    @Singleton
    @Provides
    public File provideCacheFile(Application application) {
        return DataHelper.getCacheFile(application);
    }

    /**
     * 提供RXCache客户端
     *
     * @param cacheDir 缓存路径
     * @return
     */
    @Singleton
    @Provides
    public RxCache provideRxCache(File cacheDir) {
        return new RxCache
                .Builder()
                .persistence(cacheDir, new GsonSpeaker());
    }


    private Retrofit configureRetrofit(Retrofit.Builder builder, OkHttpClient client, final HttpUrl httpUrl) {
        return builder
                .baseUrl(httpUrl)//域名
                .client(client)//设置okhttp
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create())//使用Gson
                .build();
    }

    /**
     * 配置okhttpclient
     *
     * @param okHttpClient
     * @return
     */
    private OkHttpClient configureClient(OkHttpClient.Builder okHttpClient, Cache cache, PersistentCookieJar cookieJar) {
        OkHttpClient.Builder builder = okHttpClient
                .connectTimeout(TOME_OUT, TimeUnit.SECONDS)
                .readTimeout(TOME_OUT, TimeUnit.SECONDS)
                .cache(cache)//设置缓存
                .addInterceptor(new Gbk2utf8Interceptor())
                .addInterceptor(new UnzippingInterceptor())
                .addInterceptor(new GBKUrlEncodeInterceptor())
//                .addInterceptor(new BasicAuthIntercept())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cookieJar(cookieJar);
        return builder
                .build();
    }


    private class UnzippingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            if ("gzip".equals(response.header("Content-Encoding")))
                return unzip(response);
            else
                return response;
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
            String contentType = response.header("Content-Type");
            if ("application/x-javascript".equals(contentType) || "text/html".equals(contentType))
                return gbk2utf8(response);
            else
                return response;
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

    private class GBKUrlEncodeInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            if (request.body() != null)
                request = requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=GBK"),
                        URLDecoder.decode(bodyToString(request.body()), "UTF-8")))
                        .build();
            return chain.proceed(request);
        }
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final Buffer buffer = new Buffer();
            if (request != null)
                request.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static class Buidler {
        private HttpUrl apiUrl = HttpUrl.parse("https://api.github.com/");

        public Buidler() {
        }

        public Buidler baseurl(String baseurl) {//基础url
            this.apiUrl = HttpUrl.parse(baseurl);
            return this;
        }

        public ClientModule build() {
            if (apiUrl == null) {
                throw new IllegalStateException("baseurl is required");
            }
            return new ClientModule(this);
        }


    }
}
