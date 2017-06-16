package org.gosky.nga.ui.fragment;

import org.gosky.nga.R;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.di.component.DaggerRepoComponent;
import org.gosky.nga.presenter.MinePresenter;
import org.gosky.nga.ui.base.MvpFragment;
import org.gosky.nga.view.MineView;


/**
 * Created by guozhong on 16/10/24.
 */

public class MineFragment extends MvpFragment<MinePresenter> implements MineView {



    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerRepoComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected int rootView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupView() {

    }
}
