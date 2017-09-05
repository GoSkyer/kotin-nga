/*
Copyright 2014 David Morrissey

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.gosky.nga.widget.gallery

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import kotlinx.android.synthetic.main.gallery_view_pager.*
import org.gosky.nga.R

class GalleryActivity : FragmentActivity(), OnClickListener {

    private var IMAGES: Array<String>? = null

    private var position: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery_view_pager)
        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_POSITION)) {
            position = savedInstanceState.getInt(BUNDLE_POSITION)
        }
        val images = intent.getStringArrayListExtra("images")
        IMAGES = images.toTypedArray<String>()
        position = intent.getIntExtra("position", 0)
        val horizontalPager = findViewById(R.id.vp_gallery) as ViewPager
        horizontalPager.adapter = ScreenSlidePagerAdapter(supportFragmentManager)
        horizontalPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tv_position_gallery.text = "${position + 1} / ${IMAGES?.size}"
            }

        })
        tv_position_gallery.text = "${position + 1} / ${IMAGES?.size}"
        horizontalPager.currentItem = position
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BUNDLE_POSITION, position)
    }

    override fun onClick(view: View) {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            val fragment = GalleryFragment()
            fragment.setAsset(IMAGES!![position])
            return fragment
        }

        override fun getCount(): Int {
            return IMAGES!!.size
        }
    }

    companion object {

        private val BUNDLE_POSITION = "position"
    }

}
