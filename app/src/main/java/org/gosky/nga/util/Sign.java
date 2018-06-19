package org.gosky.nga.util;

import android.util.Log;

import gov.pianzong.androidnga.jni.v;

/**
 * Created by guo on 2018/6/16.
 * desc:
 */
public class Sign {
    private static final String TAG = "Sign";
    private static volatile Sign mInstance;

    private Sign() {
    }

    public static Sign getInstance() {
        if (mInstance == null) {
            synchronized (Sign.class) {
                if (mInstance == null) {
                    mInstance = new Sign();
                }
            }
        }
        return mInstance;
    }


    public String sign(String uid, String token, String t, String[] params) {
        String s = a("1010", uid, token
                , a(params)
                , t, "392e916a6d1d8b7523e2701470000c30bc2165a1");
        String sign = v.a(s);
        Log.d(TAG, "sign: " + sign);
        return sign;
    }

    private String a(String... paramVarArgs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : paramVarArgs) {
            stringBuilder.append(append);
        }
        return v.a(stringBuilder.toString());
    }
}
