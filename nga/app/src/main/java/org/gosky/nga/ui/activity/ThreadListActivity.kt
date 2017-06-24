package org.gosky.nga.ui.activity

import org.gosky.nga.R
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.ThreadListPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.view.ThreadListView
import javax.inject.Inject

/**
 * Created by zohar on 2017/6/24.
 * desc:
 */
class ThreadListActivity : MvpActivity<ThreadListPresenter>(), ThreadListView {

    @Inject
    lateinit var threadListPresenter:ThreadListPresenter


    override fun setupActivityComponent(repoComponent: RepoComponent) {
        repoComponent.inject(this)
    }

    override fun rootView(): Int {
        return R.layout.activity_thread_list
    }

    override fun setupView() {
    }

    override fun initData() {
        threadListPresenter.threads
                .subscribe()
    }

    override fun showContent(str: String?) {
    }
}