package org.gosky.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.gosky.base.mvp.BaseMvpPresenter;

import javax.inject.Inject;
public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends BaseActivity {
    protected final String TAG = this.getClass().getSimpleName();
    @Inject
    protected P mPresenter;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ComponentInject();//依赖注入
        super.onCreate(savedInstanceState);
    }
    /**
     * 依赖注入的入口
     */
    protected abstract void ComponentInject();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();//释放资源
    }

}
