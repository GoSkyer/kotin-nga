package org.gosky.nga.view

import org.gosky.base.mvp.BaseView
import org.gosky.nga.data.entity.ThreadBean

/**
 * Created by guozhong on 16/10/24.
 */

interface BookMarkView : BaseView {
    fun refreshRcv(str: MutableList<ThreadBean>)
    fun loadMoreRcv(list: MutableList<ThreadBean>)
}
