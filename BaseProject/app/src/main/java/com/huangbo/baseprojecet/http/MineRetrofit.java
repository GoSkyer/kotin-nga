package com.huangbo.baseprojecet.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by huangb on 2017/5/9.
 * retrofit 类
 */

public class MineRetrofit {
    private static final String BASE_URL = "http://bbs.nga.cn/";
    private static volatile Retrofit retrofit;

    public MineRetrofit(OkHttpClient okHttpClient) {
        if (retrofit == null) {
            synchronized (this) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okHttpClient)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(StringConverter.FACTORY)
//                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static class StringConverter implements Converter<ResponseBody, String> {
        static final StringConverter.Factory FACTORY = new StringConverter.Factory() {
            @Override
            public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                return new StringConverter();
            }
        };

        @Override
        public String convert(ResponseBody value) throws IOException {
            //values.string 把服务器上请求的数据，转换成string格式
            return convertStream2String(value.byteStream());
        }

        private String convertStream2String(InputStream in) throws IOException {
            //inputStream转换为String 要进行gbk或者utf-8转码，否则乱码
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));
//        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            String s = sb.toString();
            Log.d("okhttp", s);
            return s;
        }
    }
}
