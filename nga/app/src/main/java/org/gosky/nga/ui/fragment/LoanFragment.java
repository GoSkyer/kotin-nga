package org.gosky.nga.ui.fragment;

import org.gosky.nga.R;
import org.gosky.nga.di.component.ActivityComponent;
import org.gosky.nga.di.component.AppComponent;
import org.gosky.nga.di.component.DaggerRepoComponent;
import org.gosky.nga.presenter.LoanFragmentPresenter;
import org.gosky.nga.ui.base.MvpFragment;
import org.gosky.nga.view.LoanView;

/**
 * Created by guozhong on 16/10/24.
 */

public class LoanFragment extends MvpFragment<LoanFragmentPresenter> implements LoanView {



    @Override
    public void showSearchError() {

    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent, ActivityComponent activityComponent) {
        DaggerRepoComponent.builder()
                .appComponent(appComponent)
                .activityComponent(activityComponent)
                .build()
                .inject(this);
    }

    @Override
    protected int rootView() {
        return R.layout.fragment_loan;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupView() {

    }
}
