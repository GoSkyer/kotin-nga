package org.gosky.nga.data.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.gosky.nga.common.utils.RxHelper;
import org.gosky.nga.data.api.cache.CacheManager;
import org.gosky.nga.data.api.service.CommonApi;

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

}
