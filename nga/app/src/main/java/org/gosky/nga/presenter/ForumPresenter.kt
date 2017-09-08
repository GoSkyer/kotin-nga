package org.gosky.nga.presenter

import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.data.impl.BrowsingHistoryImpl
import org.gosky.nga.data.impl.ThreadImpl
import org.gosky.nga.view.ForumView
import javax.inject.Inject

/**
 * Created by guozhong on 16/10/24.
 */

class ForumPresenter @Inject
constructor(private val threadImpl: ThreadImpl, private val browsingHistoryImpl: BrowsingHistoryImpl) : BaseMvpPresenter<ForumView>() {

    fun getThreads(fid: String) {
        threadImpl.getThreads(fid, "1")
                .subscribe({ mutableList -> mvpView.refreshRcv(mutableList) }, { throwable -> throwable.printStackTrace() })


    }

    fun getMoreThread(fid: String, page: String) {
        threadImpl.getThreads(fid, page)
                .subscribe({ mutableList -> mvpView.loadMoreRcv(mutableList) }, { throwable -> throwable.printStackTrace() })
    }

}
