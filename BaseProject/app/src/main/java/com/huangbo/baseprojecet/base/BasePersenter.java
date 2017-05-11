package com.huangbo.baseprojecet.base;

import com.huangbo.baseprojecet.http.MineService;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by huangb on 2017/5/10.
 * 默认persenter
 */

public class BasePersenter<T, K extends BaseModleImple> {
    public MineService mService;
    public T mView;
    public K mModuleImpl;

    public BasePersenter(MineService mService, T mView, K mModuleImpl) {
        this.mService = mService;
        this.mView = mView;
        this.mModuleImpl = mModuleImpl;
    }


}

