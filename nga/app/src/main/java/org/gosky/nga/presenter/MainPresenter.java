package org.gosky.nga.presenter;

import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.nga.view.MainView;

import javax.inject.Inject;

/**
 * Created by guozhong on 16/10/24.
 */

public class MainPresenter extends BaseMvpPresenter<MainView> {
    @Inject
    public MainPresenter() {
    }

    public void test() {
        getMvpView().showContent("hahhahah");
    }
}
