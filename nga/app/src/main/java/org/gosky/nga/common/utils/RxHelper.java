package org.gosky.nga.common.utils;


import org.gosky.nga.data.api.ApiCodeException;
import org.gosky.nga.data.entity.HttpBaseResult;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hunji on 2016/9/2.
 * desc:
 */
public class RxHelper {
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public static <T> Observable.Transformer<HttpBaseResult<T>, T> handleResult() {
        return resultObservable -> resultObservable.flatMap(tResult -> {
            if (tResult.isSuccess()) {
                return createData(tResult.getData());
            } else {
                return Observable.error(new ApiCodeException(tResult.getMessage() + ""));
            }
        });
    }
    /**
     * 创建成功的数据
     *
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}
