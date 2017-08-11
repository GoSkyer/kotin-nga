package com.kungfu.dbflow

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import java.util.*

/**
 * Created by Admin on 2017/8/2.
 */
@Table(database = AppDatabase::class)
class OpenRecent {
    @PrimaryKey
    var id: Int? = null
    @Column
    var name: String? = null
    @Column
    var date: Date? = null

    override fun toString(): String {
        return "OpenRecent(id=$id, name=$name, date=$date)"
    }

}
