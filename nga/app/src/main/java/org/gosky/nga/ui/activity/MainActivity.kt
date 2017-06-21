package org.gosky.nga.ui.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.gosky.nga.App
import org.gosky.nga.R
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.fragment.MainFragment
import org.gosky.nga.view.MainView

/**
 * Created by zohar on 2017/6/18.
 * desc:
 */
class MainActivity : MvpActivity<MainPresenter>(), MainView {

    private lateinit var views: ArrayList<Fragment>

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
        val boardHolders = App.getInstance().boardHolders
        boardHolders.map {
            views.add(MainFragment(it.boards))
        }
        Log.d(TAG, ": " + boardHolders.size);
        vpMain.adapter = viewPagerAdapter()
        tabLayout.setupWithViewPager(vpMain)

    }

    override fun initData() {

    }

    override fun showContent(str: String?) {
    }

    inner class viewPagerAdapter : FragmentPagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): android.support.v4.app.Fragment {
            return views.get(position)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return App.getInstance().boardHolders[position].categoryName
        }

        override fun getCount(): Int {
            return views.size
        }

    }

}
