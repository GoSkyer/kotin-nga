package org.gosky.nga.presenter;

import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.nga.common.utils.RxHelper;
import org.gosky.nga.data.impl.ThreadImpl;
import org.gosky.nga.view.SplashView;

/**
 * Created by Admin on 2017/7/31.
 */

public class SplashPresenter extends BaseMvpPresenter<SplashView>{
    private ThreadImpl threadImpl;

    public SplashPresenter(ThreadImpl threadImpl) {
        this.threadImpl = threadImpl;
    }
    public  void getBoard(){
        threadImpl.getBoard().compose(RxHelper.rxSchedulerHelper())
                .subscribe(boardBean -> getMvpView().showBoard(boardBean), Throwable::printStackTrace);
    }
}
