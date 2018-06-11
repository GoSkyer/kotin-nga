package gov.pianzong.androidnga.jni;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import static android.content.Context.CONTEXT_IGNORE_SECURITY;

public class y {
    private static final String TAG = "y";

    public static String a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis() / 1000L;

        Context ngacontext = null;
        try {
            ngacontext = context.createPackageContext("gov.pianzong.androidnga", CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String mD5KeyFormJNI = SignJni.getMD5KeyFormJNI(ngacontext, String.valueOf(currentTimeMillis));

        Log.d(TAG, "a: " + mD5KeyFormJNI);

        try {
            return v.a(str + mD5KeyFormJNI + currentTimeMillis) + currentTimeMillis;
        } catch (Exception e) {
            e.printStackTrace();
            return v.a("" + mD5KeyFormJNI + currentTimeMillis) + currentTimeMillis;
        }
    }
}