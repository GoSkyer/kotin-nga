package com.huangbo.baseprojecet.base;

/**
 * Created by huangb on 2017/5/10.
 * 默认view
 */

public interface BaseView<T> {
    /**
     * 成功
     */
    void onSuccess(T t);

    /**
     * 失败
     */
    void onError(String message);

    /**
     * 开始
     */
    void onStart();

}
