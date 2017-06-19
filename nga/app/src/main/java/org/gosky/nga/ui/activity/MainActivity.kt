package org.gosky.nga.ui.activity

import android.support.v4.view.PagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kale.adapter.CommonRcvAdapter
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.activity_main.*
import org.gosky.nga.App
import org.gosky.nga.R
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.item.MainAdapter
import org.gosky.nga.view.MainView

/**
 * Created by zohar on 2017/6/18.
 * desc:
 */
class MainActivity : MvpActivity<MainPresenter>(), MainView {

    private lateinit var views:ArrayList<View>

    override fun setupActivityComponent(appComponent: AppComponent?) {
        DaggerRepoComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    override fun rootView(): Int {
        return R.layout.activity_main;
    }

    override fun setupView() {
        views = ArrayList();
        val recyclerView = RecyclerView(mContext)
        recyclerView.adapter = object :CommonRcvAdapter<Any>(null){
            override fun createItem(p0: Any?): AdapterItem<*> {
                return MainAdapter()
            }

        }
        views.add(recyclerView)
        views.add(RecyclerView(mContext))
//        views.add(RecyclerView(mContext))
//        views.add(RecyclerView(mContext))
//        views.add(RecyclerView(mContext))
        vpMain.adapter = viewPagerAdapter()
        tabLayout.setupWithViewPager(vpMain)

    }

    override fun initData() {

    }

    override fun showContent(str: String?) {

    }

    inner class viewPagerAdapter: PagerAdapter() {
        override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
            return view == `object`;
        }

        override fun getPageTitle(position: Int): CharSequence {
            return App.getInstance().boardHolders[position].categoryName
        }
        override fun getCount(): Int {
           return views.size
        }

        override fun instantiateItem(container: ViewGroup?, position: Int): Any {
            container?.addView(views.get(position));
            return views[position]
        }
    }

}
