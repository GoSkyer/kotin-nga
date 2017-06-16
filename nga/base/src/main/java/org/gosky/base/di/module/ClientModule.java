package org.gosky.base.di.module;

import android.app.Application;

import com.tbruyelle.rxpermissions.RxPermissions;

import org.gosky.base.http.BasicAuthIntercept;
import org.gosky.base.http.GlobeHttpHandler;
import org.gosky.base.utils.DataHelper;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jessyan on 2016/3/14.
 */
@Module
public class ClientModule {
    private static final int TOME_OUT = 10;
    public static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;//缓存文件最大值为10Mb
    public HttpUrl mApiUrl;
    public GlobeHttpHandler mHandler;
    public Interceptor[] mInterceptors;

    /**
     * @author: jess
     * @date 8/5/16 11:03 AM
     * @description: 设置baseurl
     */
    public ClientModule(Buidler buidler) {
        this.mApiUrl = buidler.apiUrl;
        this.mHandler = buidler.handler;
        this.mInterceptors = buidler.interceptors;
    }

    public static Buidler buidler() {
        return new Buidler();
    }

    /**
     * @param cache     缓存
     * @param intercept 拦截器
     * @return
     * @author: jess
     * @date 8/30/16 1:12 PM
     * @description:提供OkhttpClient
     */
    @Singleton
    @Provides
    public OkHttpClient provideClient(Cache cache, Interceptor intercept) {
        final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        return configureClient(okHttpClient, cache, intercept);
    }

    /**
     * @param client
     * @param httpUrl
     * @return
     * @author: jess
     * @date 8/30/16 1:13 PM
     * @description: 提供retrofit
     */
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
    public Interceptor provideIntercept() {
//        return new RequestIntercept(mHandler);//打印请求信息的拦截器
        return new BasicAuthIntercept();
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



    /**
     * 提供权限管理类,用于请求权限,适配6.0的权限管理
     *
     * @param application
     * @return
     */
    @Singleton
    @Provides
    public RxPermissions provideRxPermissions(Application application) {
        return RxPermissions.getInstance(application);
    }


    /**
     * @param builder
     * @param client
     * @param httpUrl
     * @return
     * @author: jess
     * @date 8/30/16 1:15 PM
     * @description:配置retrofit
     */
    private Retrofit configureRetrofit(Retrofit.Builder builder, OkHttpClient client, final HttpUrl httpUrl) {
        return builder
                .baseUrl(httpUrl)//域名
                .client(client)//设置okhttp
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create())//使用Gson
                .build();
    }

    /**
     * 配置okhttpclient
     *
     * @param okHttpClient
     * @return
     */
    private OkHttpClient configureClient(OkHttpClient.Builder okHttpClient, Cache cache, Interceptor intercept) {

        OkHttpClient.Builder builder = okHttpClient
                .connectTimeout(TOME_OUT, TimeUnit.SECONDS)
                .readTimeout(TOME_OUT, TimeUnit.SECONDS)
                .cache(cache)//设置缓存
                .addInterceptor(intercept)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY));
//        if (mInterceptors != null && mInterceptors.length > 0) {//如果外部提供了interceptor的数组则遍历添加
//            for (Interceptor interceptor : mInterceptors) {
//                builder.addInterceptor(interceptor);
//            }
//        }
        return builder
                .build();
    }


    public static class Buidler {
        private HttpUrl apiUrl = HttpUrl.parse("https://api.github.com/");
        private GlobeHttpHandler handler;
        private Interceptor[] interceptors;

        public Buidler() {
        }

        public Buidler baseurl(String baseurl) {//基础url
            this.apiUrl = HttpUrl.parse(baseurl);
            return this;
        }

        public Buidler globeHttpHandler(GlobeHttpHandler handler) {//用来处理http响应结果
            this.handler = handler;
            return this;
        }

        public Buidler interceptors(Interceptor[] interceptors) {//动态添加任意个interceptor
            this.interceptors = interceptors;
            return this;
        }



        public ClientModule build() {
            if (apiUrl == null) {
                throw new IllegalStateException("baseurl is required");
            }
            return new ClientModule(this);
        }


    }

//    .addNetworkInterceptor(new Interceptor() {
//        @Override
//        public Response intercept(Interceptor.Chain chain) throws IOException {
//            Request request = chain.request();
//            if(!DeviceUtils.netIsConnected(UiUtils.getContext())){
//                request = request.newBuilder()
//                        .cacheControl(CacheControl.FORCE_CACHE)
//                        .build();
//                LogUtils.warnInfo("http","no network");
//            }
//            Response originalResponse = chain.proceed(request);
//            if(DeviceUtils.netIsConnected(UiUtils.getContext())){
//                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
//                String cacheControl = request.cacheControl().toString();
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", cacheControl)
//                        .removeHeader("Pragma")
//                        .build();
//            }else{
//                return originalResponse.newBuilder()
//                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
//                        .removeHeader("Pragma")
//                        .build();
//            }
//        }
//    })

}
