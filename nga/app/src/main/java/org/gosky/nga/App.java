package org.gosky.nga;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import com.bumptech.glide.request.target.ViewTarget;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.BallPulseView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import org.gosky.base.base.BaseApplication;
import org.gosky.nga.common.config.AppConfig;
import org.gosky.nga.common.config.RouterTableKt;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.di.component.DaggerAppComponent;
import org.gosky.nga.di.module.CacheModule;
import org.gosky.nga.di.module.ServiceModule;

import java.util.List;


public class App extends BaseApplication {
    private static AppComponent mAppComponent;
    private static App mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        if (!shouldInit())
            return;
        mInstance = this;
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(getAppModule())//baseApplication提供
                .clientModule(getClientModule())//baseApplication提供
                .serviceModule(new ServiceModule())//需自行创建
                .cacheModule(new CacheModule())//需自行创建
                .build();
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
        // boardHolders = new ArrayList<>();
        //數據庫初始化
        FlowManager.init(this);
        Log.i(TAG, "onCreate: ");
        TwinklingRefreshLayout.setDefaultHeader(ProgressLayout.class.getName());
        TwinklingRefreshLayout.setDefaultFooter(BallPulseView.class.getName());
        RouterTableKt.init();
        LeakCanary.install(this);
        ViewTarget.setTagId(R.id.glide_tag);
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

    public static App getInstance() {
        return mInstance;
    }

    @Override
    public void onTerminate() {
        FlowManager.destroy();
        super.onTerminate();
    }
}
