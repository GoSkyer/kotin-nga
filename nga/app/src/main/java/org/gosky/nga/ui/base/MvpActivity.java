package org.gosky.nga.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import org.gosky.base.base.BaseMvpActivity;
import org.gosky.base.di.module.ActivityModule;
import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.base.mvp.BaseView;
import org.gosky.nga.App;
import org.gosky.nga.di.component.DaggerActivityComponent;
import org.gosky.nga.di.component.DaggerRepoComponent;
import org.gosky.nga.di.component.RepoComponent;


public abstract class MvpActivity<P extends BaseMvpPresenter> extends BaseMvpActivity<P> implements BaseView {
    protected App mApp;

    @Override
    protected void ComponentInject() {
        mApp = (App) getApplication();
        RepoComponent repoComponent = DaggerRepoComponent.builder()
                .appComponent(mApp.getAppComponent())
                .activityComponent(DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build())
                .build();
        setupActivityComponent(repoComponent);
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupActivityComponent(RepoComponent repoComponent);

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    protected void showToast(String arg) {
        Toast.makeText(App.getContext(), arg, Toast.LENGTH_LONG).show();
    }

    /**
     * 短toast
     *
     * @param message
     * @param type
     */
    public void showToast(String message, int type) {
        TastyToast.makeText(App.getContext(), message, TastyToast.LENGTH_SHORT, type);
    }


    /**
     * 长toast
     *
     * @param message
     * @param type
     */
    public void shotLongToast(String message, int type) {
        TastyToast.makeText(App.getContext(), message, TastyToast.LENGTH_LONG, type);
    }

}
