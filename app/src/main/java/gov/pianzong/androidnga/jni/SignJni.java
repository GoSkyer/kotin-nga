package gov.pianzong.androidnga.jni;

import android.content.Context;

public class SignJni {
    static {
        System.loadLibrary("Sign_jni");
    }

    public static native String getMD5KeyFormJNI(Context paramContext, String paramString);
}
