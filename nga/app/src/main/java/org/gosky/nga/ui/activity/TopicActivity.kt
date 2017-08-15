package org.gosky.nga.ui.activity


import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_topic.*
import org.gosky.base.base.BaseActivity
import org.gosky.nga.R
import org.gosky.nga.ui.fragment.TopicFragment

/**
 * @author guozhong
 * @date 2017/7/26
 */
class TopicActivity : BaseActivity() {
    private val mLoadingRunnable = Runnable { tabLayout_topic_activity.setupWithViewPager(vp_topic_activity) }
    private val myHandler = Handler()

    private val tid by lazy { intent.extras["tid"].toString() }

    override fun rootView(): Int {
        return R.layout.activity_topic
    }

    override fun setupView() {
        val replies = intent.extras["replies"]
        setSupportActionBar(toolbar_topic_activity)
        supportActionBar?.title = "主题详情"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val topicAdapter = TopicAdapter(if (replies != null) replies as Int else 1)
        vp_topic_activity.adapter = topicAdapter
        window.decorView.post { myHandler.post(mLoadingRunnable) }
    }

    override fun initData() {
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