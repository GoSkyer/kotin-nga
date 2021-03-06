package org.gosky.nga.common.utils

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout

/**
 * @author guozhong
 * @date 2017/6/28
 */
fun TwinklingRefreshLayout.onRefreshListener(block1: RefreshContract.() -> Unit): RefreshContract {

    this.setFloatRefresh(true)
    this.setEnableOverScroll(false)
    val refreshContract = RefreshContract(this)
    block1.invoke(refreshContract)
    return refreshContract
}

class RefreshContract(val a: TwinklingRefreshLayout) {

    private lateinit var load: () -> Unit
    private lateinit var refresh: () -> Unit

    val lis = object : RefreshListenerAdapter() {
        override fun onRefresh(refreshLayout: TwinklingRefreshLayout?) {
            super.onRefresh(refreshLayout)
            refresh()
        }

        override fun onLoadMore(refreshLayout: TwinklingRefreshLayout?) {
            super.onLoadMore(refreshLayout)
            load()
        }
    }

    init {
        a.setOnRefreshListener(lis)
    }


    fun loadCallBack(block: () -> Unit) {
        load = block
    }

    fun refreshCallBack(block: () -> Unit) {
        refresh = block
    }
}
