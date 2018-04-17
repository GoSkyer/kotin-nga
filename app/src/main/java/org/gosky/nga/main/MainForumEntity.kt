package org.gosky.nga.main

/**
 * Created by guo on 2018/4/13.
 * desc:
 */

data class MainForumEntity(
		val code: Int,
		val msg: String,
		val result: List<Result>,
		val guest_token: String,
		val appcolumn_notis: AppcolumnNotis,
		val forum_icon_pre: String
)

data class Result(
		val id: Int,
		val name: String,
		val groups: List<Group>
)

data class Group(
		val id: Int,
		val name: String,
		val info: String,
		val forums: List<Forum>
)

data class Forum(
		val id: Int,
		val name: String,
		val info: String,
		val icon: String,
		val is_forumlist: Boolean
)

data class AppcolumnNotis(
		val version: Int,
		val notis: List<Noti>
)

data class Noti(
		val title: String,
		val url: String,
		val start_at: Int,
		val end_at: Int
)