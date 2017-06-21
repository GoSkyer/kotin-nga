package org.gosky.nga.ui.activity

import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.app_bar_main.*
import org.gosky.nga.App
import org.gosky.nga.R
import org.gosky.nga.di.component.AppComponent
import org.gosky.nga.di.component.DaggerRepoComponent
import org.gosky.nga.presenter.MainPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.ui.fragment.MainFragment
import org.gosky.nga.view.MainView

class MainActivity : MvpActivity<MainPresenter>(), MainView, NavigationView.OnNavigationItemSelectedListener {
    private lateinit var views: ArrayList<Fragment>

    override fun setupActivityComponent(appComponent: AppComponent?) {
        DaggerRepoComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    override fun rootView(): Int {
        return R.layout.activity_main
    }

    override fun setupView() {
        toolbar_main_activity.title = "nga开源版"
        setSupportActionBar(toolbar_main_activity);
        views = ArrayList();
        val boardHolders = App.getInstance().boardHolders
        boardHolders.map {
            views.add(MainFragment(it.boards))
        }
        Log.d(TAG, ": " + boardHolders.size);
        vpMain.adapter = viewPagerAdapter()
        tabLayout.setupWithViewPager(vpMain)


        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar_main_activity, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun initData() {
    }

    override fun showContent(str: String?) {

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
            return App.getInstance().boardHolders[position].categoryName
        }

        override fun getCount(): Int {
            return views.size
        }

    }

}
