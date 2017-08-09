package org.gosky.nga.view

import org.gosky.base.mvp.BaseView
import org.gosky.nga.data.entity.BoardBean

/**
 * Created by Admin on 2017/7/31.
 */

interface SplashView : BaseView {
    fun showBoard(boardBean: BoardBean)
}
