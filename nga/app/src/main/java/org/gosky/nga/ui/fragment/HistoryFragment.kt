package org.gosky.nga.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.kungfu.dbflow.History
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.fragment_main.*
import org.gosky.nga.R
import org.gosky.nga.di.component.ActivityComponent
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.activity.ForumActivity
import org.gosky.nga.ui.base.MvpFragment
import org.gosky.nga.ui.item.HistoryAdapter
import org.gosky.nga.view.HistoryView
import org.jetbrains.anko.support.v4.startActivity
import java.util.*

/**
 * @author guozhong
 * @date 2017/6/19
 */
class HistoryFragment(var list: ArrayList<History>) : MvpFragment<MainPresenter>(), HistoryView {


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
        rcv_main_fragment.layoutManager = GridLayoutManager(mContext, 3, LinearLayoutManager.VERTICAL, false)
        rcv_main_fragment.adapter = object : CommonRcvAdapter<History>(list) {
            override fun createItem(p0: Any?): AdapterItem<*> {
                return HistoryAdapter(mContext)
            }

            override fun onItemClick(model: History?, position: Int) {
                super.onItemClick(model, position)
                startActivity<ForumActivity>("forumId" to model?.id.toString(), "name" to model?.name.toString())
//                mPresenter.addHistory(model)
            }
        }
        rcv_main_fragment.adapter.notifyDataSetChanged()
    }

    override fun showHistory(list: List<History>) {
        this.list.clear()
        this.list.addAll(list)
        rcv_main_fragment.adapter.notifyDataSetChanged()
    }

    fun refresh() {
        mPresenter.getHistory()
    }

    override fun initData() {
    }


}

