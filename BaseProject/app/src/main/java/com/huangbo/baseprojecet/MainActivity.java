package com.huangbo.baseprojecet;

import android.content.Intent;
import android.os.Bundle;

import com.huangbo.baseprojecet.base.BasePersenterActivity;
import com.huangbo.baseprojecet.bean.LocationBean;
import com.huangbo.baseprojecet.module.activity.MainModule;
import com.huangbo.baseprojecet.persenter.MainPersenter;
import com.huangbo.baseprojecet.view.MainView;

public class MainActivity extends BasePersenterActivity<MainPersenter> implements MainView<LocationBean> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.get().getAppComponent().setUp(new MainModule(this)).inject(this);
        mPersenter.getData();
        findViewById(R.id.button).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, TestActiviyu.class))
        );


    }


    @Override
    public void success(LocationBean locationBean) {

    }

    @Override
    public void error() {

    }
}
