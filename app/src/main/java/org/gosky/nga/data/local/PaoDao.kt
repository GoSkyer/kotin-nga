package org.gosky.nga.data.local;

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import org.gosky.nga.login.User

@Dao
interface UserDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insetAll(articles: List<Article>)
//
//    @Query("SELECT * FROM Articles WHERE articleid= :id")
//    fun getArticleById(id:Int): Single<Article>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

}

