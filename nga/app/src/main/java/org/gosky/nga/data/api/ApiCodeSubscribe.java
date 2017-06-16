package org.gosky.nga.data.api;


import android.content.Context;

import com.blankj.utilcode.utils.NetworkUtils;

import rx.Subscriber;

/**
 * Created by hunji on 16/6/28.
 */
public abstract class ApiCodeSubscribe<T> extends Subscriber<T> {
    private Context mContext;
    //    private SweetAlertDialog dialog;
    private String msg;

    protected boolean showDialog() {
        return true;
    }

    /**
     * @param context context
     * @param msg     dialog message
     */
    public ApiCodeSubscribe(Context context, String msg) {
        this.mContext = context;
        this.msg = msg;
    }

    /**
     * @param context context
     */
    public ApiCodeSubscribe(Context context) {
        this(context, "请稍后...");
    }

    @Override
    public void onCompleted() {
        if (showDialog()) {
//            dialog.dismiss();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (showDialog()) {
//            dialog = new SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE)
//                    .setTitleText(msg);
//            dialog.setCancelable(true);
//            dialog.setCanceledOnTouchOutside(true);
//            //点击取消的时候取消订阅
//            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dialog) {
//                    if (!isUnsubscribed()) {
//                        unsubscribe();
//                    }
//                }
//            });
//            dialog.show();
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (NetworkUtils.isAvailable(mContext)) { //这里自行替换判断网络的代码
            _onError("网络不可用");
        } else if (e instanceof ApiCodeException) {
            _onApiError(e.getMessage());
        } else {
            _onError("请求失败，请稍后再试...");
        }
        if (showDialog()) {
//            dialog.dismiss();
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

    private void _onApiError(String message) {
//        if (message.equals("401")){
//            Intent i = new Intent();
//            i.setClass(mContext, LoginActivity.class);
//            mContext.startActivity(i);
//        }
    }
}
