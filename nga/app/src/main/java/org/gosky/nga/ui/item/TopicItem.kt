package org.gosky.nga.ui.item

import android.graphics.Color
import android.util.Log
import android.view.View
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.item_topic.view.*
import org.gosky.base.GlideApp
import org.gosky.nga.R
import org.gosky.nga.data.entity.TopicBean
import org.gosky.nga.widget.gallery.GalleryActivity
import org.jetbrains.anko.startActivity


/**
 * @author guozhong
 * @date 2017/7/27
 */
class TopicItem(var __U: Map<String, TopicBean.DataBean.UBean>) : AdapterItem<TopicBean.DataBean.RBean> {
    private val TAG = "TopicItem";
    private lateinit var view: View


    override fun getLayoutResId() = R.layout.item_topic;


    override fun setViews() {

    }

    override fun bindViews(p0: View?) {
        view = p0 as View
    }

    override fun OnRootClickListener(p0: TopicBean.DataBean.RBean?, p1: Int) {

    }

    override fun handleData(p0: TopicBean.DataBean.RBean?, p1: Int) {
        if (p1 % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#fff9e4"))
        } else {
            view.setBackgroundColor(Color.parseColor("#fdf5d4"))
        }

        p0?.content?.let {
            view.tv_item_topic.setText(it)
        }
        p0?.authorid.run { __U[this.toString()] }?.apply {
            GlideApp.with(view.context).load(avatar.toString()).circleCrop().into(view.iv_avatar_topic_item)
            view.tv_username_topic_item.text = username
            view.tv_user_profile_topic_item.text = "威望:$rvrc   发帖:$postnum"
            view.tv_item_topic.setOnImageClickListener { imageUrls, p ->
                Log.i(TAG, ": $imageUrls")
                view.context.startActivity<GalleryActivity>("images" to imageUrls, "position" to p)
            }

        }

    }
}