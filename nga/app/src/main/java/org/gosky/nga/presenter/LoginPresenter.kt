package org.gosky.nga.presenter

import org.gosky.base.mvp.BaseMvpPresenter
import org.gosky.nga.data.impl.UserImpl
import org.gosky.nga.data.impl.VCodeImpl
import org.gosky.nga.view.LoginView
import java.util.*
import javax.inject.Inject

/**
 * @author guozhong
 * @date 2017/7/19
 */

class LoginPresenter @Inject constructor(val vCodeImpl: VCodeImpl, val userImpl: UserImpl) : BaseMvpPresenter<LoginView>() {

    val rid = "_" + Random().nextFloat()

    fun getVCode() {
        vCodeImpl.getSmsVCode(rid)
                .subscribe({ mvpView.showVCode(it) }
                        , { it.printStackTrace() })
    }

    fun login(name: String, password: String, captcha: String) {
        userImpl.login(name = "大蘑菇菇", password = "hunji_wisdom", captcha = captcha, rid = rid)
    }


}