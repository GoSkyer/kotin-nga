package org.gosky.nga.data.entity

/**
 * Created by hunji on 2016/9/1.
 * desc:
 */
class HttpBaseResult<T> {

    /**
     * server_time : 1477284985
     * success : true
     * message :
     * data :
     */

    var server_time: Int = 0
    var isSuccess: Boolean = false
    var message: String? = null
    var data: T? = null
}
