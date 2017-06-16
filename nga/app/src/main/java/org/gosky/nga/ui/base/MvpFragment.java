package org.gosky.nga.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import org.gosky.base.base.BaseFragment;
import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.base.mvp.BaseView;
import com.sdsmdg.tastytoast.TastyToast;
import org.gosky.nga.App;
import org.gosky.nga.di.component.AppComponent;


/**
 * Created by jess on 8/5/16 14:11
 * contact with jess.yan.effort@gmail.com
 */
public abstract class MvpFragment<P extends BaseMvpPresenter> extends BaseFragment<P> implements BaseView {
    protected App mApp;

    @Override
    protected void ComponentInject() {
        mApp = (App) mActivity.getApplication();
        setupFragmentComponent(mApp.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupFragmentComponent(AppComponent appComponent);


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.attachView(this);
        setupView();
        initData();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showMessage(String agr0) {

    }

    @Override
    public Context getActivityContext() {
        return mContext;
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
