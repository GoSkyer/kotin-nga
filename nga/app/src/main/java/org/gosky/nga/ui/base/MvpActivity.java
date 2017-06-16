package org.gosky.nga.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import org.gosky.nga.App;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.base.base.BaseMvpActivity;
import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.base.mvp.BaseView;


/**
 * Created by jess on 8/5/16 13:13
 * contact with jess.yan.effort@gmail.com
 */
public abstract class MvpActivity<P extends BaseMvpPresenter> extends BaseMvpActivity<P> implements BaseView {
    protected App mApp;

    @Override
    protected void ComponentInject() {
        mApp = (App) getApplication();
        setupActivityComponent(mApp.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupActivityComponent(AppComponent appComponent);

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public void showMessage(String agr0) {

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

    @Override
    protected void onResume() {
        super.onResume();
     }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
