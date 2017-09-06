package org.gosky.nga.common.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * @author guozhong
 * @date 2017/9/6
 */


fun Context.share(uri: Uri): Boolean {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/jpeg"
        intent.putExtra(android.content.Intent.EXTRA_STREAM, uri)
        startActivity(Intent.createChooser(intent, null))
        return true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        return false
    }
}