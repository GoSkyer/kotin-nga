package org.gosky.base.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by zhiyicx on 2016/3/15.
 */
public class DataHelper {

    /**
     * 返回缓存文件夹
     */
    public static File getCacheFile(Context context) {
        if (context.getCacheDir() == null || Environment.getExternalStorageState() == null ||Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File file = null;
            file = context.getExternalCacheDir();//获取系统管理的sd卡缓存文件
            if (file == null) {//如果获取的为空,就是用自己定义的缓存文件夹做缓存路径
                file = new File(getCacheFilePath(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            return file;
        } else {
            return context.getCacheDir();
        }
    }

    /**
     * 获取自定义缓存文件地址
     * @param context
     * @return
     */
    public static String getCacheFilePath(Context context) {
        String packageName = context.getPackageName();
        return "/mnt/sdcard/" + packageName;
    }


}
