package org.gosky.nga.view;

import org.gosky.base.mvp.BaseView;
import org.gosky.nga.data.entity.ThreadBean;

import java.util.List;

/**
 * Created by guozhong on 16/10/24.
 */

public interface ForumView extends BaseView {
    void refreshRcv(List<ThreadBean> str);
    void loadMoreRcv(List<ThreadBean> list);
}
