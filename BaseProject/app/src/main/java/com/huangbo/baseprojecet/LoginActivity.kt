package com.huangbo.baseprojecet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huangbo.baseprojecet.base.BasePersenterActivity
import com.huangbo.baseprojecet.view.LoginView

class LoginActivity : BasePersenterActivity<LoginView> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
