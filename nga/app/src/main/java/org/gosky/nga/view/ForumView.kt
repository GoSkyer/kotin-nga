package org.gosky.nga.view

import org.gosky.base.mvp.BaseView
import org.gosky.nga.data.entity.ThreadBean

/**
 * Created by guozhong on 16/10/24.
 */

interface ForumView : BaseView {
    fun refreshRcv(str: List<ThreadBean>)
    fun loadMoreRcv(list: List<ThreadBean>)
}
