package org.gosky.nga.common.interceptor;

import android.content.Context;

import com.thejoyrun.router.DAConstants;
import com.thejoyrun.router.Filter;
import com.thejoyrun.router.utils.Log;


public class LoginInterceptor implements Filter {

    private static final String TAG = "LoginInterceptor";
    private Context context;

    public LoginInterceptor(Context context) {
        this.context = context;
    }


    @Override
    public String doFilter(String url) {
        Log.D(TAG, "intercept(), text: " + url);
        return DAConstants.RESULT_OK;
    }
}
