package org.gosky.nga.login

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by zohar on 2018/6/10.
 * desc:
 */

@Entity
data class User(
        @PrimaryKey
        var id: Long,
        @SerializedName("uid") val uid: Int,
        @SerializedName("username") val username: String,
        @SerializedName("avatar") val avatar: String,
        @SerializedName("token") val token: String,
        @SerializedName("bound_mobile") val boundMobile: Int,
        @SerializedName("login_type") val loginType: Int
)
