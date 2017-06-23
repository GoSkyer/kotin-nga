package org.gosky.nga.di.module;


import org.gosky.nga.data.api.cache.CommonCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;


/**
 * Created by zhiyicx on 2016/3/30.
 */
@Module
public class CacheModule {

    @Singleton
    @Provides
    CommonCache provideCommonService(RxCache rxCache) {
        return rxCache.using(CommonCache.class);
    }

}
