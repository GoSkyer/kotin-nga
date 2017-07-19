package org.gosky.nga.di.component;

import org.gosky.base.di.scope.ActivityScope;
import org.gosky.nga.ui.activity.ForumActivity;
import org.gosky.nga.ui.activity.LoginActivity;
import org.gosky.nga.ui.activity.MainActivity;
import org.gosky.nga.ui.fragment.MainFragment;

import dagger.Component;


@ActivityScope
@Component(dependencies = {AppComponent.class, ActivityComponent.class})
public interface RepoComponent {
    void inject(MainActivity activity);

    void inject(MainFragment mainFragment);

    void inject(ForumActivity forumActivity);

    void inject(LoginActivity loginActivity);
}
