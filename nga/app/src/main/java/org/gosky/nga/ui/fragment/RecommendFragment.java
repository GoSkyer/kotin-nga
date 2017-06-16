package org.gosky.nga.ui.fragment;

import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.presenter.RecommendPresenter;
import org.gosky.nga.ui.base.MvpFragment;
import org.gosky.nga.view.RecommendView;

/**
 * Created by guozhong on 16/10/24.
 */

public class RecommendFragment extends MvpFragment<RecommendPresenter> implements RecommendView {



    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    protected int rootView() {
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupView() {

    }
}
