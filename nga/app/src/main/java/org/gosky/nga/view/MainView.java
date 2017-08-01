package org.gosky.nga.view;

import org.gosky.base.mvp.BaseView;
import org.gosky.nga.data.entity.BoardBean;

import java.util.List;

/**
 * Created by guozhong on 16/10/24.
 */

public interface MainView extends BaseView {
    void showBoard(List<BoardBean.ResultBean.GroupsBean> mList);
}
