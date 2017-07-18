package org.gosky.nga.common.config

import org.gosky.nga.common.utils.routerAdd

/**
 * @author guozhong
 * @date 2017/6/30
 */
val testActivity: String = "123"


fun init() {
    routerAdd {
        config {
            key = testActivity
//            value = TestActivity::class.java

        }
    }

}