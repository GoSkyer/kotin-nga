package org.gosky.nga.ui.fragment

import kotlinx.android.synthetic.main.fragment_home.*
import org.gosky.nga.R
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.impl.VCodeImpl
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.HomePresenter
import org.gosky.nga.ui.base.MvpFragment
import org.gosky.nga.view.HomeView
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/6/16
 */
class HomeFragment : MvpFragment<HomePresenter>(), HomeView {
    @Inject
    lateinit var vCodeImpl: VCodeImpl;

    override fun setupFragmentComponent(appComponent: AppComponent?) {
        DaggerRepoComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    override fun rootView(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        vCodeImpl.smsVCode
                .compose(RxHelper.rxSchedulerHelper())
                .subscribe({ ivTest.setImageBitmap(it) }, { it.printStackTrace() });

    }

    override fun setupView() {

    }
}