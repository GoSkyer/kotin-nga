package org.gosky.nga.common.utils

import com.chenenyu.router.Router

/**
 * @author guozhong
 * @date 2017/6/30
 */
class AddRouter {
    fun config(block: ConfigBuilder.() -> Unit) {
        val configBuilder = ConfigBuilder()
        configBuilder.block()
        Router.handleRouteTable() {
            it.put(configBuilder.key, configBuilder.value)
        }
    }
}

fun routerAdd(block: AddRouter.() -> Unit): AddRouter {
    val addRouter = AddRouter()
    block.invoke(addRouter)
    return addRouter
}

class ConfigBuilder {
    var key: String? = null
    var value: Class<*>? = null
}