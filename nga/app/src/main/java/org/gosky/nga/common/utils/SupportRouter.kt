package org.gosky.nga.common.utils

import android.app.Activity
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.support.v4.app.Fragment
import com.chenenyu.router.IRouter
import com.chenenyu.router.Router

/**
 * @author guozhong
 * @date 2017/6/30
 */
inline fun <reified T : Activity> Fragment.startActivity(vararg params: Pair<String, Any>) {
    Router.build(T::class.java.name).go(this)
}

fun Activity.router(url: String) {
    Router.build(url).go(this)
}

fun Activity.routerUrl(url: String): IRouter {
    return Router.build(url)
}

fun Activity.router(block: RouterBuilder.() -> Unit) {
    val builder = RouterBuilder()
    block.invoke(builder)
    Router.build(builder.url).apply {
        builder.params?.map {
            with(it.first, it.second)
        }
        builder.requestCode?.let {
            requestCode(it)
        }
    }.go(this)
}

class RouterBuilder {
    var url: String? = null
    var params: Array<out Pair<String, Any>>? = null
    var requestCode: Int? = null

    fun addParams(vararg p: Pair<String, Any>) {
        params = p
    }
}

