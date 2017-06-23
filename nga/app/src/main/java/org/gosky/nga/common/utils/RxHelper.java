package org.gosky.nga.common.utils;


import org.gosky.nga.data.api.ApiCodeException;
import org.gosky.nga.data.entity.HttpBaseResult;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;



/**
 * Created by hunji on 2016/9/2.
 * desc:
 */
public class RxHelper {
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public static <T> ObservableTransformer<HttpBaseResult<T>, T> handleResult() {
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
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
                try {
                    observableEmitter.onNext(data);
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }

        });
    }

}
