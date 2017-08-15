package org.gosky.nga.presenter

import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.data.impl.ThreadImpl
import org.gosky.nga.view.BookMarkView
import javax.inject.Inject

/**
 * Created by guozhong on 16/10/24.
 */

class BookMarkPresenter @Inject
constructor(private val threadImpl: ThreadImpl) : BaseMvpPresenter<BookMarkView>() {

    fun getThreads() {
        threadImpl.getBookMarks(1)
                .subscribe({ mutableList -> mvpView.refreshRcv(mutableList) }, { throwable -> throwable.printStackTrace() })


    }

    fun getMoreThread(page: Int) {
        threadImpl.getBookMarks(page)
                .subscribe({ mutableList -> mvpView.loadMoreRcv(mutableList) }, { throwable -> throwable.printStackTrace() })
    }


}