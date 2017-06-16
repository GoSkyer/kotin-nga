package org.gosky.nga;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;
import com.thejoyrun.router.Router;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import org.gosky.nga.common.config.AppConfig;
import org.gosky.nga.data.api.BaseApi;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.di.component.DaggerAppComponent;
import org.gosky.nga.di.module.CacheModule;
import org.gosky.nga.di.module.ServiceModule;
import org.gosky.base.base.BaseApplication;
import org.gosky.base.http.GlobeHttpHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;


public class App extends BaseApplication {
    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (!shouldInit())
            return;
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(getAppModule())//baseApplication提供
                .clientModule(getClientModule())//baseApplication提供
                .imageModule(getImageModule())//baseApplication提供
                .serviceModule(new ServiceModule())//需自行创建
                .cacheModule(new CacheModule())//需自行创建
                .build();
        Router.init("qeeniao", this, "dynamic_action.cfg");
        MiPushClient.registerPush(this, AppConfig.mipushAppID, AppConfig.mipushAppKey);
        LoggerInterface newLogger = new LoggerInterface() {
            @Override
            public void setTag(String tag) {
                // ignore
            }

            @Override
            public void log(String content, Throwable t) {
                Log.d(TAG, content, t);
            }

            @Override
            public void log(String content) {
                Log.d(TAG, content);
            }
        };
        Logger.setLogger(this, newLogger);
        CrashReport.initCrashReport(getApplicationContext(), "900060152", false);
        Log.i(TAG, "onCreate: ");
    }

    private boolean shouldInit() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getBaseUrl() {
        return BaseApi.APP_DOMAIN;
    }

    /**
     * 将AppComponent返回出去,供其它地方使用, AppComponent接口中声明的方法返回的实例, 在getAppComponent()拿到对象后都可以直接使用
     *
     * @return
     */
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static void setmAppComponent(AppComponent mAppComponent1) {
        mAppComponent = mAppComponent1;
    }

    /**
     * 这里可以提供一个全局处理http响应结果的处理类,
     * 这里可以比客户端提前一步拿到服务器返回的结果,可以做一些操作,比如token超时,重新获取
     * 默认不实现,如果有需求可以重写此方法
     *
     * @return
     */
    @Override
    public GlobeHttpHandler getHttpHandler() {
        return new GlobeHttpHandler() {
            @Override
            public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
                //这里可以先客户端一步拿到每一次http请求的结果,可以解析成json,做一些操作,如检测到token过期后
                //重新请求token,并重新执行请求
                try {
                    JSONArray array = new JSONArray(httpResult);
                    JSONObject object = (JSONObject) array.get(0);
                    String login = object.getString("login");
                    String avatar_url = object.getString("avatar_url");
                    Timber.tag(TAG).w("result ------>" + login + "    ||   avatar_url------>" + avatar_url);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //这里如果发现token过期,可以先请求最新的token,然后在拿新的token去重新请求之前的http请求
                // create a new request and modify it accordingly using the new token
//                    Request newRequest = chain.request().newBuilder().header("token", newToken)
//                            .build();
//
//                    // retry the request
//
//                    response.body().close();
//                    try {
//                        return chain.proceed(newRequest);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                //如果需要返回新的结果,则直接把response参数返回出去
                return response;
            }

            @Override
            public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
                //如果需要再请求服务器之前做一些操作,则重新返回一个做过操作的的requeat如增加header,不做操作则返回request

                //return chain.request().newBuilder().header("token", tokenId)
//                .build();
                return request;
            }
        };
    }

}
