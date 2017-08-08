package org.gosky.nga.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.fragment_topic.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.TopicBean
import org.gosky.nga.di.component.ActivityComponent
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.TopicPresenter
import org.gosky.nga.ui.base.MvpFragment
import org.gosky.nga.ui.item.TopicItem
import org.gosky.nga.view.TopicView
import java.util.*

/**
 * @author guozhong
 * @date 2017/8/8
 */
class TopicFragment constructor(var tid: String, var p: Int) : MvpFragment<TopicPresenter>(), TopicView {
    private val list = ArrayList<TopicBean.DataBean.RBean>()


    override fun rootView(): Int = R.layout.fragment_topic

    override fun setupFragmentComponent(appComponent: AppComponent?, activityComponent: ActivityComponent?) {
        DaggerRepoComponent
                .builder()
                .appComponent(appComponent)
                .activityComponent(activityComponent)
                .build()
                .inject(this)
    }


    override fun setupView() {
        rcv_topic.layoutManager = LinearLayoutManager(mContext)
        rcv_topic.adapter = object : CommonRcvAdapter<TopicBean.DataBean.RBean>(list) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return TopicItem()
            }

        }
    }

    override fun initData() {
        mPresenter.getTopic(tid, p.toString())
    }

    override fun showTopics(p0: ArrayList<TopicBean.DataBean.RBean>) {
        list.addAll(p0);
        rcv_topic.adapter.notifyDataSetChanged()
    }
}