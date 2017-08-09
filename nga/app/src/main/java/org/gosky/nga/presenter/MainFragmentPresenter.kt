package org.gosky.nga.presenter

import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.data.impl.HistoryImpl
import org.gosky.nga.view.MainView

import javax.inject.Inject

/**
 * @author guozhong
 * *
 * @date 2017/8/4
 */

class MainFragmentPresenter @Inject
constructor(private val history: HistoryImpl) : BaseMvpPresenter<MainView>() {

    fun addHistory(model: BoardBean.ResultBean.GroupsBean.ForumsBean) {
        history.insertHistory(model)
    }

}
