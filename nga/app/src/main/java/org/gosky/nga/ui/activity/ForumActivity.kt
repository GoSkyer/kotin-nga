package org.gosky.nga.ui.activity

import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_forum.*
import org.gosky.nga.R
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.ForumPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.view.ForumView
import javax.inject.Inject

/**
 * Created by zohar on 2017/6/24.
 * desc:
 */
class ForumActivity : MvpActivity<ForumPresenter>(), ForumView {

    @Inject
    lateinit var forumPresenter: ForumPresenter


    override fun setupActivityComponent(repoComponent: RepoComponent) {
        repoComponent.inject(this)
    }

    override fun rootView(): Int {
        return R.layout.activity_forum
    }

    override fun setupView() {
        setSupportActionBar(toolbar_forum_activity)
    }

    override fun initData() {
        forumPresenter.threads
                .subscribe(Consumer {  })
    }

    override fun showContent(str: String?) {
    }
}