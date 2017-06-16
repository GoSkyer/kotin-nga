package org.gosky.nga.data.api.cache;

import org.gosky.nga.data.entity.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import rx.Observable;

/**
 * Created by jess on 8/30/16 13:53
 * Contact with jess.yan.effort@gmail.com
 */
public interface CommonCache {



    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<List<User>>> getUsers(Observable<List<User>> oUsers, DynamicKey idLastUserQueried, EvictProvider evictProvider);

//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<HomePicEntity>> getDailyList(Observable<HomePicEntity> service, DynamicKey publishTime, EvictProvider provider);
//
//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<FindMoreEntity>> getFindMore(Observable<FindMoreEntity> service, DynamicKey id, EvictProvider provider);
//
//
//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<HotStrategyEntity>> getHotStrategy(Observable<HotStrategyEntity> service, DynamicKey id, EvictProvider provider);
//
//
//    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
//    Observable<Reply<FindDetailEntity>> getFindDetail(Observable<FindDetailEntity> service, DynamicKey id, EvictProvider provider);
}
