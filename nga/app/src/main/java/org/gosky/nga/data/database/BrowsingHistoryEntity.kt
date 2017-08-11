package org.gosky.nga.data.database

import com.kungfu.dbflow.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import org.gosky.nga.data.entity.ThreadBean

/**
 * @author guozhong
 * @date 2017/8/10
 */
@Table(database = AppDatabase::class)
class BrowsingHistoryEntity(
        @PrimaryKey
        override var tid: Int = 0,
        @Column
        var last: Long = 0,
        @Column
        override var author: String? = null,
        @Column
        override var subject: String? = null,
        @Column
        override var lastposter: String? = null,
        @Column
        override var replies: Int = 0
) : ThreadBean()

