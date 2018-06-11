package org.gosky.nga.login

import com.google.gson.annotations.SerializedName


/**
 * Created by zohar on 2018/6/10.
 * desc:
 */


data class User(
        @SerializedName("uid") val uid: Int,
        @SerializedName("username") val username: String,
        @SerializedName("avatar") val avatar: String,
        @SerializedName("token") val token: String,
        @SerializedName("bound_mobile") val boundMobile: Int,
        @SerializedName("login_type") val loginType: Int
)
