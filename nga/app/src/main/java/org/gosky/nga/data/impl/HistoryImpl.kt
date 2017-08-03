package org.gosky.nga.data.impl

import android.util.Log
import com.kungfu.dbflow.History
import com.kungfu.dbflow.History_Table
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.ModelAdapter
import org.gosky.nga.data.entity.BoardBean
import java.util.*
import javax.inject.Inject

/**
 * Created by Admin on 2017/8/3.
 */

class HistoryImpl @Inject constructor() {
    fun insertHistory(model: BoardBean.ResultBean.GroupsBean.ForumsBean) {
        var adapter: ModelAdapter<History> = FlowManager.getModelAdapter(History::class.java)
        val historys: List<History> = SQLite.select()
                .from(History::class.java).where(History_Table.id.`is`(model.id))
                .queryList()
        if (historys.size > 0) {
            var history: History = historys.get(0)
            history.date = Date()
            adapter.update(history)
            Log.e("insert", "is exist,do update")
        } else {
            var history: History = History()
            history.id = model.id
            history.name = model.name
            history.date = Date()
            adapter.insert(history)
            Log.e("insert", "insert success")
        }
    }

    fun queryAll(): List<History> {
        return SQLite.select()
                .from(History::class.java).orderBy(History_Table.date.desc()).queryList()
    }
}
