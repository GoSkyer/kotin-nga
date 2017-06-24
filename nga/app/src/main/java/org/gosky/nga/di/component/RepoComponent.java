package org.gosky.nga.di.component;

import org.gosky.base.di.scope.ActivityScope;
import org.gosky.nga.ui.activity.MainActivity;
import org.gosky.nga.ui.activity.ThreadListActivity;
import org.gosky.nga.ui.fragment.HomeFragment;
import org.gosky.nga.ui.fragment.LoanFragment;
import org.gosky.nga.ui.fragment.MainFragment;
import org.gosky.nga.ui.fragment.MineFragment;
import org.gosky.nga.ui.fragment.RecommendFragment;

import dagger.Component;


@ActivityScope
@Component(dependencies = {AppComponent.class, ActivityComponent.class})
public interface RepoComponent {
    void inject(MainActivity activity);

    void inject(HomeFragment homeFragment);

    void inject(LoanFragment loanFragment);

    void inject(RecommendFragment recommendFragment);

    void inject(MineFragment mineFragment);

    void inject(MainFragment mainFragment);

    void inject(ThreadListActivity threadListActivity);
}
