package org.gosky.nga.view

import com.kungfu.dbflow.History

import org.gosky.base.mvp.BaseView
import org.gosky.nga.data.entity.BoardBean

/**
 * Created by guozhong on 16/10/24.
 */

interface MainView : BaseView {
    fun showBoard(mList: List<BoardBean.ResultBean.GroupsBean>)
}
