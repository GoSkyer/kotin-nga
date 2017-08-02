package org.gosky.base.base;

import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDexApplication;

import com.cocosw.favor.FavorAdapter;
import com.squareup.leakcanary.LeakCanary;

import org.gosky.base.di.module.AppModule;
import org.gosky.base.di.module.ClientModule;
import org.gosky.base.di.module.ImageModule;
import org.gosky.base.http.BaseApi;

import java.util.LinkedList;

import jonathanfinerty.once.Once;
import timber.log.Timber;

public abstract class BaseApplication extends MultiDexApplication {
    static private BaseApplication mApplication;
    public LinkedList<BaseActivity> mActivityList;
    private ClientModule mClientModule;
    private AppModule mAppModule;
    private ImageModule mImagerModule;
    protected final String TAG = this.getClass().getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        this.mClientModule = ClientModule//用于提供okhttp和retrofit的单列
                .buidler()
                .baseurl(BaseApi.APP_DOMAIN)
                .build();
        this.mAppModule = new AppModule(this);//提供application
        this.mImagerModule = new ImageModule();//图片加载框架默认使用glide
        FavorAdapter favorAdapter = new FavorAdapter.Builder(this).build();
        if (Config.Debug) {//Timber日志打印
            Timber.plant(new Timber.DebugTree());
        }
        if (Config.useCanary) {//leakCanary内存泄露检查
            LeakCanary.install(this);
        }
        Once.initialise(this);
    }

    /**
     * 返回一个存储所有存在的activity的列表
     *
     * @return
     */
    public LinkedList<BaseActivity> getActivityList() {
        if (mActivityList == null) {
            mActivityList = new LinkedList<BaseActivity>();
        }
        return mActivityList;
    }


    public ClientModule getClientModule() {
        return mClientModule;
    }

    public AppModule getAppModule() {
        return mAppModule;
    }

    public ImageModule getImageModule() {
        return mImagerModule;
    }

    /**
     * 返回上下文
     *
     * @return
     */
    public static Context getContext() {
        return mApplication;
    }



    /**
     * 退出所有activity
     */
    public static void killAll() {
        Intent intent = new Intent(BaseActivity.ACTION_RECEIVER_ACTIVITY);
        intent.putExtra("type", "killAll");
        getContext().sendBroadcast(intent);
    }

}
