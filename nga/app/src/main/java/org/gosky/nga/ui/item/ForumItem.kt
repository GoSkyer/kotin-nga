package org.gosky.nga.ui.item

import android.view.View
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.item_forum.view.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.ThreadBean

/**
 * Created by zohar on 2017/6/25.
 * desc:
 */
class ForumItem : AdapterItem<ThreadBean> {
    lateinit var view: View
    override fun bindViews(p0: View) {
        view = p0

    }

    override fun getLayoutResId(): Int {

        return R.layout.item_forum
    }

    override fun setViews() {

    }

    override fun handleData(p0: ThreadBean?, p1: Int) {
        p0?.let {
            view.last_reply.text = it.lastposter
            view.title.text = it.subject
            view.author.text = it.author
            view.num.text = it.replies.toString()
            if (p1 % 2 == 0){
                view.setBackgroundColor(view.context.resources.getColor(R.color.shit1))
            } else{
                view.setBackgroundColor(view.context.resources.getColor(R.color.shit2))
            }
        }

    }

    override fun OnRootClickListener(p0: ThreadBean?, p1: Int) {

    }
}