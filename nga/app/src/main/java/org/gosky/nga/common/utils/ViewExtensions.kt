package org.gosky.nga.common.utils

import android.support.design.widget.Snackbar
import android.view.View

/**
 * @author guozhong
 * @date 2017/9/6
 */
/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun View.showSnackbar(snackbarText: String, timeLength: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, snackbarText, timeLength).show()
}