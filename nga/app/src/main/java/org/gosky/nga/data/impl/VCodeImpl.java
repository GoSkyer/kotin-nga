package org.gosky.nga.data.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.gosky.nga.common.utils.RxHelper;
import org.gosky.nga.data.api.cache.CacheManager;
import org.gosky.nga.data.api.service.ApiManager;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by guozhong on 16/10/21.
 */

public class VCodeImpl {
    private ApiManager apiManager;
    private CacheManager cacheManager;

    @Inject
    public VCodeImpl(ApiManager apiManager, CacheManager cacheManager) {
        this.apiManager = apiManager;
        this.cacheManager = cacheManager;
    }

    public Observable<Bitmap> getSmsVCode() {
        return apiManager.getCommonService()
                .getImageValidCode()
                .compose(RxHelper.rxSchedulerHelper())
                .map(ResponseBody::byteStream)
                .map(BitmapFactory::decodeStream);
    }
//
//    public Observable<Object> getCaptcha(String uuid
//            , String timestamp) {
//        return apiManager.getCommonService()
//                .getCaptcha(uuid
//                        , timestamp)
//                .compose(RxHelper.rxSchedulerHelper())
//                .compose(RxHelper.handleResult());
//    }
}
