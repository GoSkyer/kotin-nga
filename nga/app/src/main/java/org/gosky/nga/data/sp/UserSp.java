package org.gosky.nga.data.sp;

import com.cocosw.favor.AllFavor;

/**
 * Created by guozhong on 16/11/2.
 */
@AllFavor
public interface UserSp {
    void setLoanHistory(String history);

    String getLoanHistory();
}
