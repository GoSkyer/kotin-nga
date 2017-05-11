package com.huangbo.baseprojecet.base;

import javax.inject.Inject;

/**
 * Created by huangb on 2017/5/10.
 */

public class BasePersenterActivity<T extends BasePersenter> extends BaseActivity {
    @Inject
    public T mPersenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPersenter.mModuleImpl.detachPersenter();
    }
}
