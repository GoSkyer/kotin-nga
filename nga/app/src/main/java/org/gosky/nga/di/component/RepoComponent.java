package org.gosky.nga.di.component;

import org.gosky.base.di.scope.ActivityScope;
import org.gosky.nga.ui.activity.BookMarkActivity;
import org.gosky.nga.ui.activity.BrowsingHistoryActivity;
import org.gosky.nga.ui.activity.ForumActivity;
import org.gosky.nga.ui.activity.LoginActivity;
import org.gosky.nga.ui.activity.MainActivity;
import org.gosky.nga.ui.activity.SecondBoardActivity;
import org.gosky.nga.ui.activity.TopicActivity;
import org.gosky.nga.ui.fragment.HistoryFragment;
import org.gosky.nga.ui.fragment.MainFragment;
import org.gosky.nga.ui.fragment.TopicFragment;
import org.jetbrains.annotations.NotNull;

import dagger.Component;


@ActivityScope
@Component(dependencies = {AppComponent.class, ActivityComponent.class})
public interface RepoComponent {
    void inject(MainActivity activity);

    void inject(MainFragment mainFragment);

    void inject(HistoryFragment mainFragment);

    void inject(ForumActivity forumActivity);

    void inject(LoginActivity loginActivity);

    void inject(SecondBoardActivity secondBoardActivity);

    void inject(TopicActivity topicActivity);

    void inject(@NotNull TopicFragment topicFragment);

    void inject(@NotNull BrowsingHistoryActivity browsingHistoryActivity);

    void inject(@NotNull BookMarkActivity bookMarkActivity);
}
