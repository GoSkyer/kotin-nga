package org.gosky.nga.data.local;

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import org.gosky.nga.login.User

@Dao
interface UserDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insetAll(articles: List<Article>)
//
    @Query("SELECT * FROM User Limit 1")
    fun getUser(): LiveData<User>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

}

