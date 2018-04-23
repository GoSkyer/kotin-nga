package org.gosky.nga.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import kale.adapter.CommonAdapter

/**
 * Created by guo on 2018/4/23.
 * desc:
 */
@BindingAdapter("items")
fun bindingRecyclerView(rcv: RecyclerView, data: Any) {
    if (rcv.adapter is CommonAdapter<*>) {
//        val commonAdapter = rcv.adapter as CommonAdapter<*>
//        commonAdapter.data = data
    }
}