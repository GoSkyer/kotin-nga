package com.huangbo.baseprojecet.view;

/**
 * Created by huangb on 2017/5/11.
 */

public interface MainView<T> {
    void success(T t);
    void error();
}
