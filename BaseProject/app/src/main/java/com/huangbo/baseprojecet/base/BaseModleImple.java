package com.huangbo.baseprojecet.base;

import com.huangbo.baseprojecet.http.ApiServices;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by huangb on 2017/5/11.
 */

public class BaseModleImple<T> {

    public ApiServices mService;
    public T mView;
    private CompositeSubscription mCompositeSubscription;

    public BaseModleImple(ApiServices mService, T mView) {
        this.mService = mService;
        this.mView = mView;
    }

    public void detachPersenter() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
//        if (!NetworkUtils.isAvailableByPing()) {
//            ToastUtils.showShortToast("网络不可用,请检查网络~");
//        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
