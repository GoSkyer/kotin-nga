package com.huangbo.baseprojecet.base;

import com.huangbo.baseprojecet.http.ApiServices;

/**
 * Created by huangb on 2017/5/10.
 * 默认persenter
 */

public class BasePersenter<T, K extends BaseModleImple> {
    public ApiServices mService;
    public T mView;
    public K mModuleImpl;

    public BasePersenter(ApiServices mService, T mView, K mModuleImpl) {
        this.mService = mService;
        this.mView = mView;
        this.mModuleImpl = mModuleImpl;
    }


}

