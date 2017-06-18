package org.gosky.nga.ui.fragment

import android.view.View
import kale.adapter.item.AdapterItem
import org.gosky.nga.R
import kotlinx.android.synthetic.main.item_main.*

import org.gosky.nga.data.entity.Board

/**
 * Created by zohar on 2017/6/18.
 * desc:
 */
class MainAdapter: AdapterItem<Board> {
    override fun OnRootClickListener(p0: Board?, p1: Int) {
    }

    override fun getLayoutResId(): Int {
       return R.layout.item_main
    }

    override fun setViews() {
    }

    override fun handleData(p0: Board?, p1: Int) {
//        ivIconItemMain.
    }

    override fun bindViews(p0: View?) {
    }
}

