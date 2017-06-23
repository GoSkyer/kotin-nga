package org.gosky.nga.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.fragment_main.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.Board
import org.gosky.nga.data.impl.ThreadImpl
import org.gosky.nga.data.impl.VCodeImpl
import org.gosky.nga.di.component.ActivityComponent
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.base.MvpFragment
import org.gosky.nga.ui.item.MainAdapter
import org.gosky.nga.view.MainView
import javax.inject.Inject


/**
 * @author guozhong
 * @date 2017/6/19
 */
class MainFragment(val list: List<Board>) : MvpFragment<MainPresenter>(), MainView {

    @Inject
    lateinit var threadImpl: ThreadImpl

    @Inject
    lateinit var vCodeImpl:VCodeImpl

    override fun setupFragmentComponent(appComponent: AppComponent, activityComponent: ActivityComponent) {
        DaggerRepoComponent
                .builder()
                .appComponent(appComponent)
                .activityComponent(activityComponent)
                .build()
                .inject(this)
    }

    override fun rootView(): Int {
        return R.layout.fragment_main
    }

    override fun setupView() {
        Log.d(TAG, ": " + list.size);
        rcv_main_fragment.layoutManager = GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false);
        rcv_main_fragment.adapter = object : CommonRcvAdapter<Board>(list) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return MainAdapter()
            }
        }
        rcv_main_fragment.adapter.notifyDataSetChanged()
    }

    override fun initData() {
//        threadImpl
//                .test()

        vCodeImpl.test()
    }


    override fun showContent(str: String?) {

    }
}

