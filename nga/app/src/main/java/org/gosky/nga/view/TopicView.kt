package org.gosky.nga.view

import org.gosky.base.mvp.BaseView
import org.gosky.nga.data.entity.TopicBean

/**
 * @author guozhong
 * @date 2017/7/26
 */
interface TopicView : BaseView {

    fun showTopics(p0: ArrayList<TopicBean.DataBean.RBean>);

}