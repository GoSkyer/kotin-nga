package org.gosky.nga.di.module;


import org.gosky.nga.data.api.service.CommonApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by zhiyicx on 2016/3/30.
 */
@Module
public class ServiceModule {

    @Singleton
    @Provides
    CommonApi provideCommonService(Retrofit retrofit) {
        return retrofit.create(CommonApi.class);
    }

}
