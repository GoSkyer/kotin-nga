package org.gosky.nga.presenter

import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.data.impl.ThreadImpl
import org.gosky.nga.view.SplashView

/**
 * Created by Admin on 2017/7/31.
 */

class SplashPresenter(private val threadImpl: ThreadImpl) : BaseMvpPresenter<SplashView>() {
    fun getBoard() {
        threadImpl.getBoard().compose<BoardBean>(RxHelper.rxSchedulerHelper<BoardBean>())
                .subscribe({ boardBean -> mvpView.showBoard(boardBean) }, { it.printStackTrace() })
    }
}
