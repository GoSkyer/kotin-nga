package org.gosky.nga.ui.activity

import android.graphics.Bitmap
import kotlinx.android.synthetic.main.activity_login.*
import org.gosky.nga.R
import org.gosky.nga.di.component.RepoComponent
import org.gosky.nga.presenter.LoginPresenter
import org.gosky.nga.ui.base.MvpActivity
import org.gosky.nga.view.LoginView

/**
 * @author guozhong
 * @date 2017/7/19
 */
class LoginActivity : MvpActivity<LoginPresenter>(), LoginView {


    override fun rootView(): Int {
        return R.layout.activity_login
    }

    override fun setupView() {
        email_sign_in_button.setOnClickListener {
            mPresenter.login("", "", et_captcha.text.toString())
        }
    }

    override fun initData() {
        mPresenter.getVCode()
    }

    override fun setupActivityComponent(repoComponent: RepoComponent?) {
        repoComponent?.inject(this)
    }

    override fun showVCode(bitmap: Bitmap) {
        iv_image_check_code.setImageBitmap(bitmap)
    }
}