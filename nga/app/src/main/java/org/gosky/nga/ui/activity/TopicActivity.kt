package org.gosky.nga.ui.activity


import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_topic.*
import org.gosky.base.base.BaseActivity
import org.gosky.base.di.module.ActivityModule
import org.gosky.nga.App
import org.gosky.nga.R
import org.gosky.nga.data.entity.ThreadBean
import org.gosky.nga.data.impl.BrowsingHistoryImpl
import org.gosky.nga.di.component.DaggerActivityComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.ui.fragment.TopicFragment
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/7/26
 */
class TopicActivity : BaseActivity() {
    private val mLoadingRunnable = Runnable { tabLayout_topic_activity.setupWithViewPager(vp_topic_activity) }
    private val myHandler = Handler()
    @Inject
    public lateinit var browsingHistoryImpl: BrowsingHistoryImpl
    private val tid by lazy { intent.extras["tid"].toString() }
    private val model: ThreadBean? by lazy { intent.extras["model"] as? ThreadBean }

    override fun rootView(): Int {
        return R.layout.activity_topic
    }

    override fun setupView() {
        inject()
        val replies = intent.extras["replies"]
        setSupportActionBar(toolbar_topic_activity)
        supportActionBar?.title = "帖子详情"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val topicAdapter = TopicAdapter(if (replies != null) replies as Int else 1)
        vp_topic_activity.adapter = topicAdapter
        window.decorView.post { myHandler.post(mLoadingRunnable) }
    }

    private fun inject() {
        DaggerRepoComponent.builder()
                .appComponent(App.getInstance().appComponent)
                .activityComponent(DaggerActivityComponent.builder().activityModule(ActivityModule(this)).build())
                .build()
                .inject(this)
    }

    override fun initData() {
        model?.let { browsingHistoryImpl.insertBrowsingHistory(it) }
    }


    override fun onDestroy() {
        super.onDestroy()
        myHandler.removeCallbacks(mLoadingRunnable)
    }

    inner class TopicAdapter(var replies: Int) : FragmentStatePagerAdapter(supportFragmentManager) {
        val reply: (Int) -> Unit = {
            if (replies != it) {
                replies = it
                notifyDataSetChanged()
            }
        }

        override fun getItem(position: Int): Fragment {
            return TopicFragment(tid, position + 1, reply)
        }

        override fun getCount(): Int = replies / 20 + 1

        override fun getPageTitle(position: Int): CharSequence {
            return position.toString()
        }
    }

}