package org.gosky.nga.ui.activity


import android.support.v7.widget.LinearLayoutManager
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.activity_topic.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.TopicBean
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.TopicPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.item.TopicItem
import org.gosky.nga.view.TopicView
import java.util.*

/**
 * @author guozhong
 * @date 2017/7/26
 */
class TopicActivity : MvpActivity<TopicPresenter>(), TopicView {

    private val list = ArrayList<TopicBean.DataBean.RBean>()

    override fun setupActivityComponent(repoComponent: RepoComponent?) {
        repoComponent?.inject(this)
    }

    override fun rootView(): Int {
        return R.layout.activity_topic
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
        mPresenter.getTopic(intent.extras["tid"].toString(), "1")
    }

    override fun showTopics(p0: ArrayList<TopicBean.DataBean.RBean>) {
        list.addAll(p0);
        rcv_topic.adapter.notifyDataSetChanged()
    }

}