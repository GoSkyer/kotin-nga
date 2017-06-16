package org.gosky.base.mvp;

import org.gosky.base.http.BaseCacheManager;
import org.gosky.base.http.BaseServiceManager;

/**
 * Created by jess on 8/5/16 12:55
 * contact with jess.yan.effort@gmail.com
 */
public class BaseModel<S extends BaseServiceManager, C extends BaseCacheManager> {
    protected S mServiceManager;//服务管理类,用于网络请求
    protected C mCacheManager;//缓存管理类,用于管理本地或者内存缓存

    public BaseModel(S serviceManager, C cacheManager) {
        this.mServiceManager = serviceManager;
        this.mCacheManager = cacheManager;
    }

    public void onDestory() {
        mServiceManager = null;
        mCacheManager = null;
    }
}
