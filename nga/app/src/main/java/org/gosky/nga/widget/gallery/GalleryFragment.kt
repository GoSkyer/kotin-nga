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


import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import org.gosky.base.GlideApp
import org.gosky.nga.R
import java.io.File

class GalleryFragment : Fragment() {
    private var resource: File? = null

    private var asset: String? = null

    fun getAsset() = asset

    fun setAsset(asset: String) {
        this.asset = asset
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.view_pager_page, container, false)

        if (savedInstanceState != null) {
            if (asset == null && savedInstanceState.containsKey(BUNDLE_ASSET)) {
                asset = savedInstanceState.getString(BUNDLE_ASSET)
            }
        }
        if (asset != null) {
            val imageView = rootView.findViewById(R.id.vp_imageView) as SubsamplingScaleImageView

            GlideApp.with(this).load(asset).downloadOnly(object : SimpleTarget<File>() {
                override fun onResourceReady(resource: File?, p1: Transition<in File>?) {
                    this@GalleryFragment.resource = resource
                    imageView.setImage(ImageSource.uri(Uri.fromFile(resource)))
                }
            })
            imageView.setOnClickListener {
                if (activity is GalleryActivity) {
                    (activity as GalleryActivity).changerBottomBarVisibility()
                }
            }
        }

        return rootView
    }

    fun getResourceFile(): File? {
        return resource
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val rootView = view
        if (rootView != null) {
            outState!!.putString(BUNDLE_ASSET, asset)
        }
    }

    companion object {

        private val BUNDLE_ASSET = "asset"
    }

}
