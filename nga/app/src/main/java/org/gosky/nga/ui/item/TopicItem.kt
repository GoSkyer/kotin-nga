package org.gosky.nga.ui.item

import android.view.View
import kale.adapter.item.AdapterItem
import kotlinx.android.synthetic.main.item_topic.view.*
import org.gosky.nga.R
import org.gosky.nga.data.entity.TopicBean
import org.kefirsf.bb.BBProcessorFactory


/**
 * @author guozhong
 * @date 2017/7/27
 */
class TopicItem : AdapterItem<TopicBean.DataBean.RBean> {
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
        val processor = BBProcessorFactory.getInstance().createFromResource("assets/nga_default.xml")
        view.tv_item_topic.setText(p0?.content)

//        p0?.content?.apply {
//            val process = processor.process(this)
////            view.tv_item_topic.setHtml(process, URLImageParser(view.context, view.tv_item_topic))
//
//        }

    }
}