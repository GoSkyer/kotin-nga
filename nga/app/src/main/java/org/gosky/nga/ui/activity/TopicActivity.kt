package org.gosky.nga.ui.activity


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


    private val tid by lazy { intent.extras["tid"].toString() }

    override fun rootView(): Int {
        return R.layout.activity_topic
    }

    override fun setupView() {
        val topicAdapter = TopicAdapter(intent.extras["replies"] as Int)
        vp_topic_activity.adapter = topicAdapter
        tabLayout_topic_activity.setupWithViewPager(vp_topic_activity)
    }

    override fun initData() {
    }

    inner class TopicAdapter(var replies: Int) : FragmentStatePagerAdapter(supportFragmentManager) {

        override fun getItem(position: Int): Fragment {
            return TopicFragment(tid, position)
        }

        override fun getCount(): Int = replies / 20 + 1

        override fun getPageTitle(position: Int): CharSequence {
            return position.toString()
        }
    }

}