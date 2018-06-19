package org.gosky.nga.util;

import android.util.Log;

import gov.pianzong.androidnga.jni.MD5;

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
        String sign = a("1010", uid, token
                , b(params)
                , t, "392e916a6d1d8b7523e2701470000c30bc2165a1");
        Log.d(TAG, "sign: " + sign);
        return sign;
    }

    private String a(String... paramVarArgs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : paramVarArgs) {
            stringBuilder.append(append);
        }
        return MD5.a(stringBuilder.toString());
    }

    private String b(String... paramVarArgs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : paramVarArgs) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }
}
