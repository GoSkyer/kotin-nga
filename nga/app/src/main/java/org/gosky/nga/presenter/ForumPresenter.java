package org.gosky.nga.presenter;

import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.nga.data.impl.ThreadImpl;
import org.gosky.nga.view.ForumView;

import javax.inject.Inject;

/**
 * Created by guozhong on 16/10/24.
 */

public class ForumPresenter extends BaseMvpPresenter<ForumView> {

    private ThreadImpl threadImpl;

    @Inject
    public ForumPresenter(ThreadImpl threadImpl) {
        this.threadImpl = threadImpl;
    }

    public void getThreads(String fid) {
        threadImpl.getThreads(fid)
                .subscribe((threadBeen, throwable) -> {
                    getMvpView().refreshRcv(threadBeen);
                    if (throwable != null)
                        throwable.printStackTrace();
                });
    }
}
