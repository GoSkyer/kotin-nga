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

import org.gosky.base.base.BaseApplication;
import org.gosky.nga.common.config.AppConfig;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.di.component.DaggerAppComponent;
import org.gosky.nga.di.module.CacheModule;
import org.gosky.nga.di.module.ServiceModule;

import java.util.List;


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

    /**
     * 将AppComponent返回出去,供其它地方使用, AppComponent接口中声明的方法返回的实例, 在getAppComponent()拿到对象后都可以直接使用
     *
     * @return
     */
    public AppComponent getAppComponent() {
        return mAppComponent;
    }


}