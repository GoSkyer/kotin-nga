package org.gosky.nga.view

import com.kungfu.dbflow.OpenRecent
import org.gosky.base.mvp.BaseView

/**
 * @author guozhong
 * @date 2017/8/4
 */
interface OpenRecent : BaseView {
    fun showHistory(list: List<OpenRecent>)
}