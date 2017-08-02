package org.gosky.base.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import org.gosky.base.mvp.BaseMvpPresenter;


public abstract class BaseFragment<P extends BaseMvpPresenter> extends RxFragment {
    protected BaseMvpActivity mActivity;
    protected View mRootView;
    protected final String TAG = this.getClass().getSimpleName();

    protected Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(rootView(), null);
        Log.i(TAG, "onCreateView: ");
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseMvpActivity) getActivity();
        mContext = getContext();
        Log.i(TAG, "onActivityCreated: ");
        setupView();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    protected abstract int rootView();

    protected abstract void initData();

    protected abstract void setupView();


}
