package org.gosky.nga.ui.activity


import org.gosky.nga.R
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.TopicPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.view.TopicView

/**
 * @author guozhong
 * @date 2017/7/26
 */
class TopicActivity : MvpActivity<TopicPresenter>(), TopicView {
    override fun setupActivityComponent(repoComponent: RepoComponent?) {
        repoComponent?.inject(this)
    }

    override fun rootView(): Int {
        return R.layout.activity_topic
    }

    override fun setupView() {
    }

    override fun initData() {
        mPresenter.getTopic(intent.extras["tid"].toString(), "1")
    }

}