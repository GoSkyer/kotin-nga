package com.kungfu.dbflow

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by Admin on 2017/8/2.
 */
@Database(version = AppDatabase.VERSION,name = AppDatabase.NAME)
 object AppDatabase {
    const val VERSION = 1
    const val NAME = "AppDatabase"
}