package org.gosky.nga.common.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Html
import android.util.Log
import android.widget.TextView
import com.bumptech.glide.GenericRequestBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.load.resource.transcode.BitmapToGlideDrawableTranscoder
import com.bumptech.glide.request.target.Target
import org.gosky.nga.R


/**
 * @author guozhong
 * @date 2017/7/27
 */
class GlideImageGetter(context: Context, glide: RequestManager, private val targetView: TextView, animated: Boolean, private val width: Int, private val height: Int) : Html.ImageGetter, Drawable.Callback {
    private val glide: GenericRequestBuilder<String, *, *, GlideDrawable>
    private val imageTargets = ArrayList<Target<GlideDrawable>>()
    private val context: Context
    private val TAG = "GlideImageGetter";

    init {
        this.context = context.getApplicationContext()
        this.glide = createGlideRequest(glide, animated)
        targetView.tag = this
    }

    interface MyDataModel {
        fun buildUrl(width: Int, height: Int): String
    }

    private fun createGlideRequest(glide: RequestManager,
                                   animated: Boolean): GenericRequestBuilder<String, *, *, GlideDrawable> {
        val load: GenericRequestBuilder<String, *, *, GlideDrawable>
        if (animated) {
            load = glide
                    .fromString()
                    //".asDrawable()" default loading handles animated GIFs and still images as well
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE) // animated GIFs need source cache
                    // show full image when animating
                    .fitCenter()
        } else {
            load = glide
                    .fromString()
                    // force still images
                    .asBitmap()
                    // make compatible with target
                    .transcode(BitmapToGlideDrawableTranscoder(context), GlideDrawable::class.java)
                    // cache resized images (RESULT), and re-use SOURCE cached GIFs if any
                    .placeholder(R.mipmap.ic_launcher)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    // show part of the image when still
                    .centerCrop()
        }
        return load// common settings
        //.listener(new LoggingListener<String, GlideDrawable>())
    }

    override fun getDrawable(url: String): Drawable {
        // set up target for this Image inside the TextView
        val imageTarget = WrapperTarget(width, height)
        val asyncWrapper = imageTarget.getLazyDrawable()
        // listen for Drawable's request for invalidation
        asyncWrapper.setCallback(this)

        // start Glide's async load
        val s = "http://img.nga.cn/attachments" + url.replace("./", "/" + ".medium.jpg")
        glide.load(s).into(imageTarget)
        Log.i(TAG, ": " + s);
        // save target for clearing it later
        imageTargets.add(imageTarget)
        return asyncWrapper
    }

    fun clear() {
        for (target in imageTargets) {
            Glide.clear(target)
        }
    }

    override fun invalidateDrawable(who: Drawable) {
        targetView.invalidate()
        targetView.text = targetView.text
    }

    override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {

    }

    override fun unscheduleDrawable(who: Drawable, what: Runnable) {

    }

    companion object {

        fun clear(view: TextView) {
            view.text = null
            val tag = view.tag
            if (tag is GlideImageGetter) {
                tag.clear()
                view.tag = null
            }
        }
    }
}