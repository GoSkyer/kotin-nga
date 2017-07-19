package org.gosky.nga.data.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.gosky.nga.common.config.DataConfig;
import org.gosky.nga.common.utils.RxHelper;
import org.gosky.nga.data.api.cache.CacheManager;
import org.gosky.nga.data.api.service.CommonApi;
import org.gosky.nga.data.entity.ThreadBean;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by guozhong on 16/10/21.
 */

public class VCodeImpl {
    private CommonApi apiManager;
    private CacheManager cacheManager;
    private static final String TAG = "VCodeImpl";


    @Inject
    public VCodeImpl(CommonApi apiManager, CacheManager cacheManager) {
        this.apiManager = apiManager;
        this.cacheManager = cacheManager;
    }

    public Observable<Bitmap> getSmsVCode(String rid) {
        return apiManager
                .getImageValidCode(rid)
                .compose(RxHelper.rxSchedulerHelper())
                .map(ResponseBody::byteStream)
                .map(BitmapFactory::decodeStream);
    }


    public void test() {
        Map<String, ThreadBean> o = new Gson().fromJson(DataConfig.str, new TypeToken<Map<String, ThreadBean>>() {
        }.getType());
        Log.i(TAG, "test: " + o.toString());
    }
}
