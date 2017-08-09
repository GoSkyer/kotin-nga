package org.gosky.nga.ui.item

import android.view.View
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.CropCircleTransformation
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.item_topic.view.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.TopicBean


/**
 * @author guozhong
 * @date 2017/7/27
 */
class TopicItem : AdapterItem<TopicBean.DataBean.RBean> {
    private lateinit var view: View
    private lateinit var __U: Map<String, TopicBean.DataBean.UBean>

    override fun getLayoutResId() = R.layout.item_topic;


    override fun setViews() {

    }

    override fun bindViews(p0: View?) {
        view = p0 as View
    }

    override fun OnRootClickListener(p0: TopicBean.DataBean.RBean?, p1: Int) {

    }

    override fun handleData(p0: TopicBean.DataBean.RBean?, p1: Int) {
        p0?.content?.let {
            view.tv_item_topic.setText(it)
        }
        p0?.authorid.run { __U[this.toString()] }?.apply {
            Glide.with(view.context).load(avatar.toString()).bitmapTransform(CropCircleTransformation(view.context)).into(view.iv_avatar_topic_item)
            view.tv_username_topic_item.text = username
            view.tv_user_profile_topic_item.text = "威望:$rvrc   发帖:$postnum"
        }

    }

    fun setUserBean(__U: Map<String, TopicBean.DataBean.UBean>) {
        this.__U = __U
    }
}