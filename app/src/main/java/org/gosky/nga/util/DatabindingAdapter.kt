package org.gosky.nga.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by zohar on 2018/6/13.
 * desc:
 */
@BindingAdapter("app:load")
fun ImageView.load(url: String?) {
    Picasso.get().load(url).into(this)
}