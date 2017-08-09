package org.gosky.nga.view

import org.gosky.base.mvp.BaseView
import org.gosky.nga.data.entity.BoardBean

/**
 * Created by guozhong on 16/10/24.
 */

interface MainView : BaseView {
    fun showBoard(mList: MutableList<BoardBean.ResultBean.GroupsBean>)
}
