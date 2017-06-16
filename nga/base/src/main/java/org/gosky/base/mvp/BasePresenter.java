package org.gosky.base.mvp;

import android.support.annotation.UiThread;

/**
 * Created by jess on 16/4/28.
 */
public interface BasePresenter<V extends BaseView> {
    @UiThread
    void attachView(V  view);
    @UiThread
    void detachView();
}
