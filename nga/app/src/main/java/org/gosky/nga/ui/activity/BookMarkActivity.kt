package org.gosky.nga.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.activity_forum.*
import org.gosky.nga.R
import org.gosky.nga.common.config.topicActivity
import org.gosky.nga.common.utils.onRefreshListener
import org.gosky.nga.common.utils.router
import org.gosky.nga.data.entity.ThreadBean
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.BookMarkPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.item.ForumItem
import org.gosky.nga.view.BookMarkView
import java.util.*

/**
 * Created by zohar on 2017/6/24.
 * desc:
 */
class BookMarkActivity : MvpActivity<BookMarkPresenter>(), BookMarkView {

    val threadList: ArrayList<ThreadBean> = ArrayList()
    val fid: String by lazy { intent.extras["forumId"].toString() }
    var page = 1

    override fun setupActivityComponent(repoComponent: RepoComponent) {
        repoComponent.inject(this)
    }

    override fun rootView(): Int {
        return R.layout.activity_forum
    }

    override fun setupView() {
        setSupportActionBar(toolbar_forum_activity)
        supportActionBar?.title = "我的收藏"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        rcv_forum_activity.layoutManager = LinearLayoutManager(mContext)
        rcv_forum_activity.adapter = object : CommonRcvAdapter<ThreadBean>(threadList) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return ForumItem()
            }

            override fun onItemClick(model: ThreadBean?, position: Int) {
                super.onItemClick(model, position)
                router {
                    url = topicActivity
                    addParams("tid" to model?.tid.toString(), "replies" to model?.replies!!.toInt(), "model" to model)
                }
            }
        }
        refresh_forum_activity.onRefreshListener {
            refreshCallBack {
                mPresenter.getThreads()
            }

            loadCallBack {
                mPresenter.getMoreThread(page + 1)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initData() {
        mPresenter.getThreads()
    }

    override fun refreshRcv(list: MutableList<ThreadBean>) {
        page = 1
        threadList.clear()
        threadList.addAll(list.toList())
        rcv_forum_activity.adapter.notifyDataSetChanged()
        refresh_forum_activity.finishRefreshing()
    }

    override fun loadMoreRcv(list: MutableList<ThreadBean>) {
        page++
        threadList.addAll(list.toList())
        rcv_forum_activity.adapter.notifyDataSetChanged()
        refresh_forum_activity.finishLoadmore()
    }
}