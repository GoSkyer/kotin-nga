package org.gosky.nga.main

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.gosky.nga.ForumFragment
import org.gosky.nga.R
import org.gosky.nga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity";
    val mainViewModel = MainViewModel()
    val listener = mainViewModel.model.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(p0: Observable?, p1: Int) {
            vp_main.adapter.notifyDataSetChanged()
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = mainViewModel
        mainViewModel.getData()
        vp_main.adapter = MainViewPagerAdapter()
        tl_main.setupWithViewPager(vp_main)

    }


    inner class MainViewPagerAdapter : FragmentStatePagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): Fragment {
            return ForumFragment()
        }

        override fun getCount(): Int {
            return mainViewModel.model.get()?.result?.size ?: 0
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mainViewModel.model.get().result[position].name
        }

    }
}
