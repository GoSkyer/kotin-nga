package org.gosky.nga.data.impl

import android.util.Log
import com.kungfu.dbflow.History
import com.kungfu.dbflow.History_Table
import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.orderBy
import com.raizlabs.android.dbflow.kotlinextensions.save
import com.raizlabs.android.dbflow.kotlinextensions.select
import org.gosky.nga.data.entity.BoardBean
import java.util.*
import javax.inject.Inject

/**
 * Created by Admin on 2017/8/3.
 */

class HistoryImpl @Inject constructor() {
    private val TAG = "HistoryImpl";

    fun insertHistory(model: BoardBean.ResultBean.GroupsBean.ForumsBean) {
        val history = History()
        history.id = model.id
        history.name = model.name
        history.date = Date()
        history.save()
        Log.i(TAG, "save success")
    }

    fun queryAll(): List<History> {
        return select { from(History::class) orderBy History_Table.date.desc() }.queryList()
    }
}
