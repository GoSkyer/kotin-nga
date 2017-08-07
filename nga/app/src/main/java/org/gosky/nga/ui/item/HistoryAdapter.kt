package org.gosky.nga.ui.item

import android.content.Context
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.kungfu.dbflow.History
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.item_main.view.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.Board
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.data.impl.UserImpl
import org.gosky.nga.data.impl.VCodeImpl


/**
 * Created by zohar on 2017/6/18.
 * desc:
 */
class HistoryAdapter constructor(val context:  Context) : AdapterItem<History> {
    private lateinit var view: View

    override fun OnRootClickListener(p0: History?, p1: Int) {
    }

    override fun getLayoutResId(): Int {
       return R.layout.item_main
    }

    override fun setViews() {

    }

    override fun handleData(p0: History?, p1: Int) {
        view.tvNameItemMain.text = p0?.name
        p0?.id?.let { Glide.with(context).load("https://img4.nga.cn/ngabbs/nga_classic/f/app/"+p0.id+".png").error(R.mipmap.default_icon).into(view.ivIconItemMain) }
    }

    override fun bindViews(p0: View?) {
        view = p0 as View
    }
}
