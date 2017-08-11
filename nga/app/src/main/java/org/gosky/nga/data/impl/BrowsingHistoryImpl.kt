package org.gosky.nga.data.impl

import com.raizlabs.android.dbflow.kotlinextensions.*
import com.raizlabs.android.dbflow.rx2.kotlinextensions.rx
import org.gosky.nga.data.database.BrowsingHistoryEntity
import org.gosky.nga.data.database.BrowsingHistoryEntity_Table
import org.gosky.nga.data.entity.ThreadBean
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/8/11
 */
class BrowsingHistoryImpl @Inject constructor() {
    private val TAG = "BrowsingHistoryImpl";

    fun insertBrowsingHistory(threadBean: ThreadBean) {
        threadBean.apply {
            BrowsingHistoryEntity(tid, System.currentTimeMillis(), author, subject, lastposter, replies).save()
        }
    }

    fun queryAllBrowsingHistory(page: Int)
            = select { from(BrowsingHistoryEntity::class) orderBy BrowsingHistoryEntity_Table.last.desc() limit 10 offset 10 * (page - 1) }.rx().queryList()
}