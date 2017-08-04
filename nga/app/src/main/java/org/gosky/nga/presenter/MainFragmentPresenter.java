package org.gosky.nga.presenter;

import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.nga.data.entity.BoardBean;
import org.gosky.nga.data.impl.HistoryImpl;
import org.gosky.nga.view.MainView;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

/**
 * @author guozhong
 * @date 2017/8/4
 */

public class MainFragmentPresenter extends BaseMvpPresenter<MainView> {
    private HistoryImpl history;

    @Inject
    public MainFragmentPresenter(HistoryImpl history) {
        this.history = history;
    }

    public void addHistory(@NotNull BoardBean.ResultBean.GroupsBean.ForumsBean model) {
        history.insertHistory(model);
    }

}
