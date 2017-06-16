package org.gosky.nga.ui.fragment;

import android.util.Log;

import org.gosky.nga.R;
import org.gosky.nga.data.impl.VCodeImpl;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.di.component.DaggerRepoComponent;
import org.gosky.nga.presenter.HomePresenter;
import org.gosky.nga.ui.base.MvpFragment;
import org.gosky.nga.view.HomeView;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by guozhong on 16/10/24.
 */

public class HomeFragment extends MvpFragment<HomePresenter> implements HomeView {

    @Inject
    VCodeImpl vCode;

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerRepoComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);

    }

    @Override
    protected int rootView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        vCode.getSmsVCode()
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            Log.d("HomeFragment", "responseBody:" + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    protected void setupView() {

    }
}
