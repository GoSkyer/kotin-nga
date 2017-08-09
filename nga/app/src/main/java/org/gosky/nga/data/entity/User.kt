package org.gosky.nga.data.entity


class User(val id: Int, val login: String, private val avatar_url: String) {

    val avatarUrl: String
        get() {
            if (avatar_url.isEmpty()) return avatar_url
            return avatar_url.split("\\?".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
        }

    override fun toString(): String {
        return "id -> $id login -> $login"
    }
}
