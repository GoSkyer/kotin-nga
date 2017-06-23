package org.gosky.nga.di.component;


import com.tbruyelle.rxpermissions2.RxPermissions;

import org.gosky.base.di.module.ActivityModule;

import dagger.Component;

/**
 * @author guozhong
 * @date 2017/6/23
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    //用于请求权限,适配6.0的权限管理
    RxPermissions rxPermissions();
}
