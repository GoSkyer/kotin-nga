package org.gosky.nga.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author guozhong
 * *
 * @date 2017/7/21
 */

class LoginBean {

    /**
     * 0 : 登录成功
     * 1 : 25944452
     * 2 : Z8fb0soavsk4ppdhrlhs85bmbg7avt72n8mrvgb0
     * 3 : {"uid":25944452,"username":"大蘑菇菇","avatar":"http://img.nga.178.com/attachments/mon_201409/13/-152678_54136d8d608de.jpg"}
     */

    @SerializedName("0")
    var msg: String? = null
    @SerializedName("1")
    var uid: Int = 0
    @SerializedName("2")
    var cid: String? = null
    @SerializedName("3")
    var user: LoginUser? = null

    class LoginUser {
        /**
         * uid : 25944452
         * username : 大蘑菇菇
         * avatar : http://img.nga.178.com/attachments/mon_201409/13/-152678_54136d8d608de.jpg
         */

        var uid: Int = 0
        var username: String? = null
        var avatar: String? = null
    }

    override fun toString(): String {
        return "LoginBean{" +
                "msg='" + msg + '\'' +
                ", uid=" + uid +
                ", cid='" + cid + '\'' +
                ", user=" + user +
                '}'
    }
}
