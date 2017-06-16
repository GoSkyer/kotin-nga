package org.gosky.base.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import org.gosky.base.mvp.BaseMvpPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by jess on 2015/12/8.
 */
public abstract class BaseFragment<P extends BaseMvpPresenter> extends RxFragment {
    protected BaseMvpActivity mActivity;
    protected View mRootView;
    protected final String TAG = this.getClass().getSimpleName();
    @Inject
    protected P mPresenter;
    protected Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(rootView(), null);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseMvpActivity) getActivity();
        ComponentInject();
        mContext = getContext();
    }

    /**
     * 依赖注入的入口
     */
    protected abstract void ComponentInject();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (mPresenter != null) mPresenter.onDestroy();//释放资源
        ButterKnife.unbind(this);
    }


    protected abstract int rootView();

    protected abstract void initData();

    protected abstract void setupView();

    public void setData(Object data) {

    }

    public void setData() {

    }

}
