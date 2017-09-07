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

import android.Manifest
import android.animation.Animator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.FileProvider
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.gallery_view_pager.*
import org.gosky.nga.R
import org.gosky.nga.common.utils.share
import org.gosky.nga.common.utils.showSnackbar
import java.io.File


class GalleryActivity : FragmentActivity() {

    private var IMAGES: Array<String>? = null

    private var position: Int = 0

    private val screenSlidePagerAdapter by lazy { ScreenSlidePagerAdapter(supportFragmentManager) }

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
        horizontalPager.adapter = screenSlidePagerAdapter
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
        iv_download_gallery.setOnClickListener {
            savePic()
        }
        iv_share_gallery.setOnClickListener {
            sharePic()
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BUNDLE_POSITION, position)
    }

    private fun sharePic() {
        val item = screenSlidePagerAdapter.getCurrentFragment()
        if (item is GalleryFragment) {
            println(item.getResourceFile())
            item.getResourceFile()?.let { FileProvider.getUriForFile(this, packageName, it) }?.let { baseContext.share(it) }
        }
    }

    private fun savePic() {
        RxPermissions(this).request(Manifest.permission_group.STORAGE)
                .subscribe({
                    if (it) {
                        val item = screenSlidePagerAdapter.getCurrentFragment()
                        if (item is GalleryFragment) {
                            println(item.getResourceFile())
                            val let = item.getAsset()?.let { File(it.toString()) }?.name
                            println(let)
                            item.getResourceFile()?.let {
                                val target = File("${Environment.getExternalStorageDirectory()}/nga/$let")
                                it.copyTo(target, true)
                                sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                                        Uri.fromFile(target)))
                                iv_download_gallery.showSnackbar("图片保存至$target~")
                            }
                        }
                    } else {
                        iv_download_gallery.showSnackbar("没有sd卡权限 无法保存图片啦")
                    }
                }, {
                    it.printStackTrace()
                })
    }

    fun changerBottomBarVisibility() {
        if (ll_bottom_bar_gallery.visibility == View.VISIBLE) {
            hiddenBottomBar()
        } else {
            showBottomBar()
        }
    }

    private fun hiddenBottomBar() {
        val duration = ll_bottom_bar_gallery.animate().alpha(0f).setDuration(150)
        duration.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                ll_bottom_bar_gallery.visibility = View.INVISIBLE
            }
        })
    }

    private fun showBottomBar() {
        ll_bottom_bar_gallery.visibility = View.VISIBLE
        val duration = ll_bottom_bar_gallery.animate().alpha(1f).setDuration(150)
        duration.setListener(null)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        private lateinit var mCurrentFragment: GalleryFragment

        override fun getItem(position: Int): Fragment {
            val fragment = GalleryFragment()
            fragment.setAsset(IMAGES!![position])
            return fragment
        }

        override fun getCount(): Int {
            return IMAGES!!.size
        }

        override fun setPrimaryItem(container: ViewGroup?, position: Int, `object`: Any) {
            mCurrentFragment = `object` as GalleryFragment
            super.setPrimaryItem(container, position, `object`)
        }

        fun getCurrentFragment(): GalleryFragment? {
            return mCurrentFragment
        }
    }

    companion object {

        private val BUNDLE_POSITION = "position"
    }

}
