package org.gosky.nga.main

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.gosky.nga.R
import org.gosky.nga.databinding.ActivityMainBinding
import org.gosky.nga.login.LoginActivity
import org.gosky.nga.util.load
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val TAG = "MainActivity";

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = mainViewModel
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        mainViewModel.getData()
        mainViewModel.user.observe(this, Observer {
            Log.d(TAG, ": $it.toString()");
            if (it != null) {
                tv_name?.text = it.username
                iv_head?.load(it.avatar)
                tv_desc?.text = it.uid.toString()
                nav_view.getHeaderView(0).isClickable = false
            } else {
                tv_name?.text = "游客"
                tv_desc?.text = "点这里登陆"
                nav_view.getHeaderView(0).isClickable = true
            }
        })

        nav_view.getHeaderView(0).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_game -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fl_main_content, MainFragment.newInstance(ArrayList(mainViewModel.model.get()?.result?.get(0)?.groups)))
                fragmentTransaction.commit()
            }
            R.id.nav_mobile_game -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fl_main_content, MainFragment.newInstance(ArrayList(mainViewModel.model.get()?.result?.get(1)?.groups)))
                fragmentTransaction.commit()
            }
            R.id.nav_talk -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fl_main_content, MainFragment.newInstance(ArrayList(mainViewModel.model.get()?.result?.get(2)?.groups)))
                fragmentTransaction.commit()
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
