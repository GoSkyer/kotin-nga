package org.gosky.nga.data.impl

import android.util.Log
import com.kungfu.dbflow.OpenRecent
import com.kungfu.dbflow.OpenRecent_Table
import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.orderBy
import com.raizlabs.android.dbflow.kotlinextensions.save
import com.raizlabs.android.dbflow.kotlinextensions.select
import com.raizlabs.android.dbflow.rx2.kotlinextensions.rx
import io.reactivex.Single
import org.gosky.nga.data.entity.BoardBean
import java.util.*
import javax.inject.Inject

/**
 * Created by Admin on 2017/8/3.
 */

class HistoryImpl @Inject constructor() {
    private val TAG = "HistoryImpl"

    fun insertHistory(model: BoardBean.ResultBean.GroupsBean.ForumsBean) {
        val history = OpenRecent()
        history.id = model.id
        history.name = model.name
        history.date = Date()
        history.save()
        Log.i(TAG, "save success")
    }

    fun queryAll(): Single<MutableList<OpenRecent>> {
        return select { from(OpenRecent::class) orderBy OpenRecent_Table.date.desc() }.rx().queryList()
    }
}
