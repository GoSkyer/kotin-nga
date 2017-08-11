package org.gosky.nga.presenter

import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.data.impl.BrowsingHistoryImpl
import org.gosky.nga.view.BrowsingHistoryView
import javax.inject.Inject

/**
 * Created by guozhong on 16/10/24.
 */

class BrowsingHistoryPresenter @Inject
constructor(private val browsingHistoryImpl: BrowsingHistoryImpl) : BaseMvpPresenter<BrowsingHistoryView>() {

    fun getThreads() {
        browsingHistoryImpl.queryAllBrowsingHistory(1)
                .subscribe({ mutableList -> mvpView.refreshRcv(mutableList) }, { throwable -> throwable.printStackTrace() })


    }

    fun getMoreThread(page: Int) {
        browsingHistoryImpl.queryAllBrowsingHistory(page)
                .subscribe({ mutableList -> mvpView.loadMoreRcv(mutableList) }, { throwable -> throwable.printStackTrace() })
    }
}
