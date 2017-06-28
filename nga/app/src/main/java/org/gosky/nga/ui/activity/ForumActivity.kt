package org.gosky.nga.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.activity_forum.*
import org.gosky.nga.R
import org.gosky.nga.common.utils.onRefreshListener
import org.gosky.nga.data.entity.ThreadBean
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.ForumPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.item.ForumItem
import org.gosky.nga.view.ForumView

/**
 * Created by zohar on 2017/6/24.
 * desc:
 */
class ForumActivity : MvpActivity<ForumPresenter>(), ForumView {

    val threadList: ArrayList<ThreadBean> = ArrayList()
    val fid: String by lazy { intent.extras["forumId"].toString() }

    override fun setupActivityComponent(repoComponent: RepoComponent) {
        repoComponent.inject(this)
    }

    override fun rootView(): Int {
        return R.layout.activity_forum
    }

    override fun setupView() {
        setSupportActionBar(toolbar_forum_activity)
        toolbar_forum_activity.title = intent.extras["name"].toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        rcv_forum_activity.layoutManager = LinearLayoutManager(mContext)
        rcv_forum_activity.adapter = object : CommonRcvAdapter<ThreadBean>(threadList) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return ForumItem()
            }
        }
        refresh_forum_activity.onRefreshListener {
            refreshL {
                mPresenter.getThreads(fid)
            }

            loadL {
                mPresenter.getMoreThread(fid, (threadList.size / 40 + 1).toString())
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
        mPresenter.getThreads(fid)
    }

    override fun refreshRcv(list: MutableList<ThreadBean>) {
        threadList.clear()
        threadList.addAll(list.toList())
        rcv_forum_activity.adapter.notifyDataSetChanged()
        refresh_forum_activity.finishRefreshing()
    }

    override fun loadMoreRcv(list: MutableList<ThreadBean>) {
        threadList.addAll(list.toList())
        rcv_forum_activity.adapter.notifyDataSetChanged()
        refresh_forum_activity.finishLoadmore()
    }
}