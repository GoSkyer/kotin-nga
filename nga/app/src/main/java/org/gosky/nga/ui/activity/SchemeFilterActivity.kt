package org.gosky.nga.ui.activity

import android.app.Activity
import android.os.Bundle
import com.chenenyu.router.Router

/**
 * How to handle route from browser.
 * Created by chen on 17-5-9.
 */
class SchemeFilterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uri = intent.data
        Router.build(uri).go(this)
        finish()
    }
}
