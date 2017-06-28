package org.gosky.nga.common.utils

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout

/**
 * @author guozhong
 * @date 2017/6/28
 */
fun TwinklingRefreshLayout.onRefreshListener(block1: () -> Unit, block2: () -> Unit) {

    val lis = object : RefreshListenerAdapter() {
        override fun onRefresh(refreshLayout: TwinklingRefreshLayout?) {
            super.onRefresh(refreshLayout)
            block1()
        }

        override fun onLoadMore(refreshLayout: TwinklingRefreshLayout?) {
            super.onLoadMore(refreshLayout)
            block2()
        }
    }
    this.setFloatRefresh(true)
    this.setEnableOverScroll(false)
    this.setOnRefreshListener(lis)
}
