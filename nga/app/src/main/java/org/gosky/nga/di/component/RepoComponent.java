package org.gosky.nga.di.component;

import org.gosky.base.di.scope.ActivityScope;
import org.gosky.nga.ui.activity.MainActivity;
import org.gosky.nga.ui.fragment.HomeFragment;
import org.gosky.nga.ui.fragment.LoanFragment;
import org.gosky.nga.ui.fragment.MineFragment;
import org.gosky.nga.ui.fragment.RecommendFragment;

import dagger.Component;


/**
 * Created by jess on 9/4/16 11:17
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface RepoComponent {
    void inject(MainActivity activity);
    void inject(HomeFragment homeFragment);
    void inject(LoanFragment loanFragment);
    void inject(RecommendFragment recommendFragment);
    void inject(MineFragment mineFragment);
}
