package org.gosky.nga.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.data.impl.HistoryImpl
import org.gosky.nga.view.OpenRecent
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/8/4
 */
class HistoryPresenter @Inject constructor(var history: HistoryImpl) : BaseMvpPresenter<OpenRecent>() {

    fun getHistory() {
        history.queryAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t1, t2 ->
                    mvpView.showHistory(t1)
                    t2?.printStackTrace()
                }
    }
}
