package com.huangbo.baseprojecet.persenter;

import com.huangbo.baseprojecet.http.ApiServices;
import com.huangbo.baseprojecet.impl.AuthImpl;
import com.huangbo.baseprojecet.view.LoginView;

import javax.inject.Inject;

/**
 * Created by huangb on 2017/5/11.
 */

public class LoginPresenter {

    LoginView loginView;

    AuthImpl auth;

    @Inject
    public LoginPresenter(ApiServices mService, LoginView mView, AuthImpl mModuleImpl) {
        auth = mModuleImpl;
        loginView = mView;
    }

    public void getData(){
        auth.getAuthCode();
    }

}
