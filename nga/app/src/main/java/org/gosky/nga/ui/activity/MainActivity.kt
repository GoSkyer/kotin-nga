package org.gosky.nga.ui.activity

import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.kungfu.dbflow.History
import kotlinx.android.synthetic.main.app_bar_main.*
import org.gosky.nga.R
import org.gosky.nga.common.config.loginActivity
import org.gosky.nga.common.utils.router
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.fragment.HistoryFragment
import org.gosky.nga.ui.fragment.MainFragment
import org.gosky.nga.view.MainView
import java.util.*

class MainActivity : MvpActivity<MainPresenter>(), MainView, NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private lateinit var titles: ArrayList<String>
    private lateinit var views: ArrayList<Fragment>


    override fun setupActivityComponent(repoComponent: RepoComponent) {
        repoComponent.inject(this)
    }

    override fun rootView(): Int {
        return R.layout.activity_main
    }

    override fun setupView() {
        toolbar_main_activity.title = "NGA开源版"
        setSupportActionBar(toolbar_main_activity)
        mPresenter.getBoard()
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar_main_activity, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun showBoard(mList: MutableList<BoardBean.ResultBean.GroupsBean>) {
        views = ArrayList()
        titles = ArrayList()
        for (item in mList) {
            views.add(MainFragment(item.forums))
            titles.add(item.name)
        }
        views.add(0, HistoryFragment(ArrayList<History>()))
        titles.add(0, "最近访问")
        vpMain.adapter = viewPagerAdapter()
        tabLayout.setupWithViewPager(vpMain)
        vpMain.currentItem = 1
        vpMain.addOnPageChangeListener(this)
    }



    override fun initData() {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageSelected(position: Int) {
        if (position == 0)
            (views[0] as HistoryFragment).refresh()
    }


    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
            router(loginActivity)
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    inner class viewPagerAdapter : FragmentPagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): android.support.v4.app.Fragment {
            return views.get(position)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles.get(position)
        }

        override fun getCount(): Int {
            return views.size
        }

    }

}
