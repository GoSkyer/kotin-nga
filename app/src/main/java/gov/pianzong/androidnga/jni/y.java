package gov.pianzong.androidnga.jni;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

import static android.content.Context.CONTEXT_IGNORE_SECURITY;

public class y {
    private static final String TAG = "y";

    public static String a(Context context, String str) {
//        long currentTimeMillis = System.currentTimeMillis() / 1000L;
        long currentTimeMillis = 1528542311;
//        String mD5KeyFormJNI = SignJni.getMD5KeyFormJNI(context, String.valueOf(currentTimeMillis));
        String mD5KeyFormJNI = "f4999a7ba380ab06515bb8c844560d40";

//        String signature = getSignature(context);
//        Log.d(TAG, "signature: " + signature);

        Context ngacontext = null;
        try {
            ngacontext = context.createPackageContext("gov.pianzong.androidnga", CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "a: " + SignJni.getMD5KeyFormJNI(ngacontext, String.valueOf(currentTimeMillis)));
//        Log.d(TAG, "a: " + v.a(signature + "12d6af9da0f1fe4e3c87f76ce0aec149" + currentTimeMillis));

        try {
            return v.a(str + mD5KeyFormJNI + currentTimeMillis) + currentTimeMillis;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "Exception: ");
            return v.a("" + mD5KeyFormJNI + currentTimeMillis) + currentTimeMillis;
        }
    }

    public static String getSignature(Context context) {
        try {
            /** 通过包管理器获得指定包名包含签名的包信息 **/
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            /******* 通过返回的包信息获得签名数组 *******/
            Signature[] signatures = packageInfo.signatures;
            /******* 循环遍历签名数组拼接应用签名 *******/
            return signatures[0].toCharsString();
            /************** 得到应用签名 **************/
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}