package com.huangbo.baseprojecet.view;

import com.huangbo.baseprojecet.base.BaseView;

/**
 * Created by huangb on 2017/5/11.
 */

public interface TestView<T> {
    void success(T t);
    void error();
}