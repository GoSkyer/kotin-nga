package org.gosky.base.http;

import com.cocosw.favor.AllFavor;
import com.cocosw.favor.Default;
import com.cocosw.favor.FavorAdapter;
import org.gosky.base.base.BaseApplication;

/**
 * Created by qeeniao on 16/10/20.
 */
@AllFavor
public interface HttpUser {
    @Default("")
    String getToken();

    @Default("")
    String getTel();

    void setTel(String tel);

    void setToken(String token);

    class init {
        static FavorAdapter favorAdapter = new FavorAdapter.Builder(BaseApplication.getContext()).build();
        static HttpUser hero = favorAdapter.create(HttpUser.class);

        public static HttpUser get() {
            return hero;
        }
    }

}
