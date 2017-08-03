package org.gosky.nga.presenter;


import android.util.Log;

import org.gosky.base.mvp.BaseMvpPresenter;
import org.gosky.nga.common.utils.RxHelper;
import org.gosky.nga.data.entity.BoardBean;
import org.gosky.nga.data.impl.HistoryImpl;
import org.gosky.nga.data.impl.ThreadImpl;
import org.gosky.nga.view.MainView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by guozhong on 16/10/24.
 */

public class MainPresenter extends BaseMvpPresenter<MainView> {
    private ThreadImpl threadImpl;
    private HistoryImpl history;
    @Inject
    public MainPresenter(ThreadImpl thread,HistoryImpl history) {
        this.threadImpl = thread;
        this.history = history;
    }

    public void getBoard() {
        threadImpl.getBoard().compose(RxHelper.rxSchedulerHelper())
                .map(boardBean -> {
                    List<BoardBean.ResultBean.GroupsBean> mList = new ArrayList<>();
                    for (BoardBean.ResultBean resultBean : boardBean.getResult()) {
                        mList.addAll(resultBean.getGroups());
                    }
                    return mList;
                })
                .map(list -> {
                        List<BoardBean.ResultBean.GroupsBean> mList = new ArrayList<>();
                        for (BoardBean.ResultBean.GroupsBean item : list) {
                           Iterator<BoardBean.ResultBean.GroupsBean.ForumsBean> sListIterator = item.getForums().iterator();
                           while (sListIterator.hasNext()) {
                              BoardBean.ResultBean.GroupsBean.ForumsBean e = sListIterator.next();
                              if (e.isIs_forumlist()) {
                                  BoardBean.ResultBean.GroupsBean groupBean = new BoardBean.ResultBean.GroupsBean();
                                  groupBean.setName(e.getName());
                                  groupBean.setForums(e.getForums());
                                  mList.add(groupBean);
                                  sListIterator.remove();
                                }
                           }
                           mList.add(item);
                      }
                    return mList;
                }).subscribe(list -> getMvpView().showBoard(list), Throwable::printStackTrace);
    }

    public void addHistory(@NotNull BoardBean.ResultBean.GroupsBean.ForumsBean model) {
        history.insertHistory(model);
    }

    public void getHistory(){
        getMvpView().showHistory(history.queryAll());
    }
}
