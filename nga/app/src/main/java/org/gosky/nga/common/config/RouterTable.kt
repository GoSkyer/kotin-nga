package org.gosky.nga.common.config

import org.gosky.nga.common.utils.routerAdd
import org.gosky.nga.ui.activity.LoginActivity
import org.gosky.nga.ui.activity.TopicActivity

/**
 * @author guozhong
 * @date 2017/6/30
 */
val testActivity: String = "123"
val loginActivity  = "LoginActivity"
val topicActivity  = "TopicActivity"

fun init() {
    routerAdd {
        config {
            key = testActivity
//            value = TestActivity::class.java

        }
        config {
            key = loginActivity
            value = LoginActivity::class.java
        }

        config {
            key = topicActivity
            value = TopicActivity::class.java
        }
    }

}