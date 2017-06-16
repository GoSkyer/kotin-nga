package org.gosky.nga.data.impl;

import org.gosky.nga.data.api.cache.CacheManager;
import org.gosky.nga.data.api.service.ApiManager;

import javax.inject.Inject;

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

//    public Observable<Object> getSmsVCode( String type, String address) {
//        return apiManager.getCommonService()
//                .getSmsVcode(type, address, AppUtils.getAppName(App.getContext()))
//                .compose(RxHelper.rxSchedulerHelper())
//                .compose(RxHelper.handleResult());
//    }
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
