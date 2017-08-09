package org.gosky.nga.presenter

import android.util.Log
import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.entity.TopicBean
import org.gosky.nga.data.impl.ThreadImpl
import org.gosky.nga.view.TopicView
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/7/26
 */
class TopicPresenter
@Inject constructor(val threadImpl: ThreadImpl) : BaseMvpPresenter<TopicView>() {
    private val TAG = "TopicPresenter";

    fun getTopic(tid: String, page: String) {
        threadImpl.getTopic(tid, page)
                .compose(RxHelper.rxSchedulerHelper())
                .subscribe({
                    topicBean ->
                    Log.i(TAG, ": " + topicBean.toString())
                    mvpView.showTopics(topicBean.data)
                }, {
                    it.printStackTrace()
                })
    }

}