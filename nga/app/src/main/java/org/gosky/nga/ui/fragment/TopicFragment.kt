package org.gosky.nga.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.fragment_topic.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.TopicBean
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.TopicPresenter
import org.gosky.nga.ui.base.MvpFragment
import org.gosky.nga.ui.item.TopicItem
import org.gosky.nga.view.TopicView
import java.util.*

/**
 * @author guozhong
 * @date 2017/8/8
 */
class TopicFragment constructor(var tid: String = "", var p: Int = 0, var reply: (replies: Int) -> Unit = {}) : MvpFragment<TopicPresenter>(), TopicView {

    private val list = ArrayList<TopicBean.DataBean.RBean>()
    private lateinit var __U: Map<String, TopicBean.DataBean.UBean>

    override fun setupFragmentComponent(repoComponent: RepoComponent?) {
        repoComponent?.inject(this)
    }

    override fun rootView(): Int = R.layout.fragment_topic


    override fun setupView() {
        rcv_topic.layoutManager = LinearLayoutManager(mContext)
        rcv_topic.adapter = object : CommonRcvAdapter<TopicBean.DataBean.RBean>(list) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return TopicItem(__U)
            }

        }

    }

    override fun initData() {
        mPresenter.getTopic(tid, p.toString())
    }

    override fun showTopics(p0: TopicBean.DataBean) {
        list.clear()
        list.addAll(p0.__R?.values?.toMutableList() as ArrayList<TopicBean.DataBean.RBean>);
        p0.__U?.run { __U = this }
        p0.__T?.replies?.let { reply(it) }
        rcv_topic.adapter.notifyDataSetChanged()
    }
}