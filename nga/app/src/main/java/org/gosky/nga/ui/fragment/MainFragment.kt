package org.gosky.nga.ui.fragment

import org.gosky.nga.R
import org.gosky.nga.data.entity.Board
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.base.MvpFragment
import org.gosky.nga.view.MainView

/**
 * @author guozhong
 * @date 2017/6/19
 */
class MainFragment : MvpFragment<MainPresenter>(), MainView {

    constructor(list:List<Board>){

    }


    override fun setupFragmentComponent(appComponent: AppComponent?) {
        DaggerRepoComponent
                .builder()
                .appComponent(appComponent)
                .build()
                .inject(this)
    }

    override fun rootView(): Int {
        return R.layout.fragment_main
    }

    override fun setupView() {

    }

    override fun initData() {
    }


    override fun showContent(str: String?) {

    }
}