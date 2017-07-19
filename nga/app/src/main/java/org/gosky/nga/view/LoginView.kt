package org.gosky.nga.view

import android.graphics.Bitmap
import org.gosky.base.mvp.BaseView

/**
 * @author guozhong
 * @date 2017/7/19
 */
interface LoginView : BaseView {
    fun showVCode(bitmap: Bitmap)
}