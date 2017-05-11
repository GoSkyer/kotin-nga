package com.huangbo.baseprojecet.sconp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by huangb on 2017/5/9.
 * 自定义范围(APP下)
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MainSconp {
}

