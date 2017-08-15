package org.gosky.nga.presenter


import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.common.utils.RxHelper
import org.gosky.nga.data.entity.BoardBean
import org.gosky.nga.data.impl.HistoryImpl
import org.gosky.nga.data.impl.ThreadImpl
import org.gosky.nga.view.MainView
import java.util.*
import javax.inject.Inject


/**
 * Created by guozhong on 16/10/24.
 */

class MainPresenter @Inject
constructor(private val threadImpl: ThreadImpl, private val history: HistoryImpl) : BaseMvpPresenter<MainView>() {

    fun getBoard() {
        threadImpl.getBoard().compose(RxHelper.rxSchedulerHelper<BoardBean>())
                .map<List<BoardBean.ResultBean.GroupsBean>> { boardBean ->
                    val mList = ArrayList<BoardBean.ResultBean.GroupsBean>()
                    for (resultBean in boardBean.result!!) {
                        mList.addAll(resultBean.groups!!)
                    }
                    mList
                }
                .map<List<BoardBean.ResultBean.GroupsBean>> { list ->
                    val mList = ArrayList<BoardBean.ResultBean.GroupsBean>()
                    for (item in list) {
                        var sListIterator = item.forums!!.iterator()
                        while (sListIterator.hasNext()) {
                            val e = sListIterator.next()
                            if (e.is_forumlist) {
                                val groupBean = BoardBean.ResultBean.GroupsBean()
                                groupBean.name = e.name
                                groupBean.forums = e.forums
                                mList.add(groupBean)
                                sListIterator.remove()
                            }
                        }
                        mList.add(item)
                    }
                    mList
                }.subscribe({ list -> mvpView.showBoard(list.toMutableList()) }, { it.printStackTrace() })
    }

}
