package org.gosky.nga.ui.item

import android.view.View
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.item_main.view.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.Board


/**
 * Created by zohar on 2017/6/18.
 * desc:
 */
class MainAdapter : AdapterItem<Board> {
    private lateinit var view: View
    override fun OnRootClickListener(p0: Board?, p1: Int) {
    }

    override fun getLayoutResId(): Int {

       return R.layout.item_main
    }

    override fun setViews() {

    }

    override fun handleData(p0: Board?, p1: Int) {
        view.tvNameItemMain.text = p0?.getName()

    }

    override fun bindViews(p0: View?) {
        view = p0 as View
//        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_main,parent,false)
    }
}

