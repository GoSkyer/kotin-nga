package org.gosky.base.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.LinkedList;

import butterknife.ButterKnife;

/**
 * Created by guozhong on 16/11/3.
 */

public abstract class BaseActivity extends RxAppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    private BroadcastReceiver mBroadcastReceiver;
    public static final String ACTION_RECEIVER_ACTIVITY = "com.jess.activity";
    protected BaseApplication mApplication;
    protected Context mContext;
    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        }

        if (name.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        }

        if (name.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }

        if (view != null) return view;

        return super.onCreateView(name, context, attrs);
    }


    @Override
    protected void onResume() {
        super.onResume();
        registReceiver();//注册广播
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregistReceriver();
    }

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (BaseApplication) getApplication();
        mContext = this;
        synchronized (BaseActivity.class) {
            mApplication.getActivityList().add(this);
        }
        setContentView(rootView());
        ButterKnife.bind(this);//绑定到butterknife
        Log.i(TAG, "onCreate: base");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.i(TAG, "onPostCreate: base");
        setupView();
        initData();
    }

    public void FullScreencall() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (BaseActivity.class) {
            mApplication.getActivityList().remove(this);
        }
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 注册广播
     */
    public void registReceiver() {
        try {
            mBroadcastReceiver = new BaseActivity.ActivityReceriver();
            IntentFilter filter = new IntentFilter(ACTION_RECEIVER_ACTIVITY);
            registerReceiver(mBroadcastReceiver, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 解除注册广播
     */
    public void unregistReceriver() {
        if (mBroadcastReceiver == null) return;
        try {
            unregisterReceiver(mBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected abstract int rootView();

    protected abstract void  setupView();

    protected abstract void initData();

    /**
     * 用于处理当前activity需要
     */
    class ActivityReceriver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                switch (intent.getStringExtra("type")) {
                    case "startActivity"://启动activity
                        Intent content = intent.getExtras().getParcelable("content");
                        startActivity(content);
                        break;
                    case "showSnackbar"://显示snackbar
                        String text = intent.getStringExtra("content");
                        boolean isLong = intent.getBooleanExtra("long", false);
                        View view = BaseActivity.this.getWindow().getDecorView().findViewById(android.R.id.content);
                        Snackbar.make(view, text, isLong ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT).show();
                        break;
                    case "killAll":
                        LinkedList<BaseActivity> copy;
                        synchronized (BaseActivity.class) {
                            copy = new LinkedList<BaseActivity>(mApplication.getActivityList());
                        }
                        for (BaseActivity baseActivity : copy) {
                            baseActivity.finish();
                        }
                        //		android.os.Process.killProcess(android.os.Process.myPid());
                        break;
                }
            }
        }
    }
}
