package org.gosky.nga.presenter;

import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.nga.data.entity.ThreadBean;
import org.gosky.nga.data.impl.ThreadImpl;
import org.gosky.nga.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by guozhong on 16/10/24.
 */

public class ThreadListPresenter extends BaseMvpPresenter<MainView> {

    private ThreadImpl threadImpl;
    @Inject
    public ThreadListPresenter(ThreadImpl threadImpl) {
        this.threadImpl = threadImpl;
    }

    public Single<List<ThreadBean>> getThreads() {
        return threadImpl.getThreads();
    }
}
