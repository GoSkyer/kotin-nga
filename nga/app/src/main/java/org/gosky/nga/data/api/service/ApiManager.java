package org.gosky.nga.data.api.service;

import org.gosky.base.http.BaseServiceManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jess on 8/5/16 13:01
 * contact with jess.yan.effort@gmail.com
 */
@Singleton
public class ApiManager extends BaseServiceManager {
    private CommonApi mCommonService;

    /**
     * 如果需要添加service只需在构造方法中添加对应的service,在提供get方法返回出去,只要在ServiceModule提供了该service
     * Dagger2会自行注入
     * @param commonService
     */
    @Inject
    public ApiManager(CommonApi commonService){
        this.mCommonService = commonService;
    }

    public CommonApi getCommonService() {
        return mCommonService;
    }
}
