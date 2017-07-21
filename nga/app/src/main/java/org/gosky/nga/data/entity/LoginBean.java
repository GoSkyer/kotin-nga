package org.gosky.nga.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author guozhong
 * @date 2017/7/21
 */

public class LoginBean {

    /**
     * 0 : 登录成功
     * 1 : 25944452
     * 2 : Z8fb0soavsk4ppdhrlhs85bmbg7avt72n8mrvgb0
     * 3 : {"uid":25944452,"username":"大蘑菇菇","avatar":"http://img.nga.178.com/attachments/mon_201409/13/-152678_54136d8d608de.jpg"}
     */

    @SerializedName("0")
    private String msg;
    @SerializedName("1")
    private int uid;
    @SerializedName("2")
    private String cid;
    @SerializedName("3")
    private LoginUser user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public LoginUser getUser() {
        return user;
    }

    public void setUser(LoginUser user) {
        this.user = user;
    }

    public static class LoginUser {
        /**
         * uid : 25944452
         * username : 大蘑菇菇
         * avatar : http://img.nga.178.com/attachments/mon_201409/13/-152678_54136d8d608de.jpg
         */

        private int uid;
        private String username;
        private String avatar;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "msg='" + msg + '\'' +
                ", uid=" + uid +
                ", cid='" + cid + '\'' +
                ", user=" + user +
                '}';
    }
}
