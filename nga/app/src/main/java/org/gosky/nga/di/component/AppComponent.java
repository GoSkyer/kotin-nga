package org.gosky.nga.di.component;

import android.app.Application;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.google.gson.Gson;

import org.gosky.base.di.module.AppModule;
import org.gosky.base.di.module.ClientModule;
import org.gosky.base.di.module.ImageModule;
import org.gosky.base.widget.imageloader.ImageLoader;
import org.gosky.nga.data.api.cache.CacheManager;
import org.gosky.nga.data.api.service.CommonApi;
import org.gosky.nga.di.module.CacheModule;
import org.gosky.nga.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;


@Singleton
@Component(modules = {AppModule.class, ClientModule.class, ServiceModule.class, ImageModule.class, CacheModule.class})
public interface AppComponent {
    Application Application();

    //服务管理器,retrofitApi
    CommonApi serviceManager();

    //缓存管理器
    CacheManager cacheManager();

    OkHttpClient okHttpClient();

    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoader();

    //gson
    Gson gson();

    // cookie
    PersistentCookieJar cookieJar();
}
