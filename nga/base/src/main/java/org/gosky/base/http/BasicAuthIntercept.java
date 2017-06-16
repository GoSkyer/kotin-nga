package org.gosky.base.http;

import android.content.Context;

import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.DeviceUtils;
import org.gosky.base.base.BaseApplication;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by guozhong on 16/10/24.
 */

public class BasicAuthIntercept implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Context context = BaseApplication.getContext();
        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization", HttpUser.init.get().getToken())
//                .header("Accept", "application/json")
                .method(original.method(), original.body());

        HttpUrl originalHttpUrl = original.url();
        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("bundle_id", AppUtils.getAppPackageName(context))
                .addQueryParameter("platform", "android")
                .addQueryParameter("device_key", DeviceUtils.getAndroidID(context))
                .addQueryParameter("app_version", AppUtils.getAppVersionName(context))
                .addQueryParameter("os_version", DeviceUtils.getSDKVersion() + "")
                .addQueryParameter("hardware", DeviceUtils.getModel())
                .build();
        requestBuilder.url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
