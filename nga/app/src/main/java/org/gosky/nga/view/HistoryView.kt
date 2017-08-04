package org.gosky.nga.view

import com.kungfu.dbflow.History
import org.gosky.base.mvp.BaseView

/**
 * @author guozhong
 * @date 2017/8/4
 */
interface HistoryView : BaseView {
    fun showHistory(list: List<History>)
}