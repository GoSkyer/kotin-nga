package org.gosky.nga.presenter

import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.data.impl.HistoryImpl
import org.gosky.nga.view.HistoryView
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/8/4
 */
class HistoryPresenter @Inject constructor(var history: HistoryImpl): BaseMvpPresenter<HistoryView>() {

    fun getHistory() {
        mvpView.showHistory(history.queryAll())
    }
}