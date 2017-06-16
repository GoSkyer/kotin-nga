package org.gosky.nga.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.gosky.base.base.BaseFragment;
import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.base.mvp.BaseView;
import org.gosky.nga.App;
import org.gosky.nga.di.component.AppComponent;

import javax.inject.Inject;


public abstract class MvpFragment<P extends BaseMvpPresenter> extends BaseFragment<P> implements BaseView  {
    protected App mApp;
    @Inject
    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ComponentInject();
        mPresenter.attachView(this);

    }

    protected void ComponentInject() {
        mApp = (App) mActivity.getApplication();
        setupFragmentComponent(mApp.getAppComponent());
    }


    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupFragmentComponent(AppComponent appComponent);

    @Override
    public Context getActivityContext() {
        return mContext;
    }

}
