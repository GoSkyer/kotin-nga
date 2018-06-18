package org.gosky.nga.login

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.*
import android.webkit.WebSettings.LOAD_NO_CACHE
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.squareup.moshi.Moshi
import gov.pianzong.androidnga.jni.y
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.gosky.nga.R
import org.gosky.nga.data.local.AppDatabase
import org.jetbrains.anko.toast
import java.util.*


class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity";
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        WebView.setWebContentsDebuggingEnabled(true);

        val localWebSettings = webview_test.settings

        localWebSettings.useWideViewPort = true;
        localWebSettings.loadWithOverviewMode = true;
        localWebSettings.javaScriptEnabled = true;
        localWebSettings.setSupportZoom(true);
        localWebSettings.builtInZoomControls = true;
        localWebSettings.pluginState = WebSettings.PluginState.ON;
        localWebSettings.allowFileAccess = true;
        localWebSettings.defaultTextEncodingName = "GBK";
        localWebSettings.defaultZoom = WebSettings.ZoomDensity.FAR;
        localWebSettings.domStorageEnabled = true;
        localWebSettings.cacheMode = LOAD_NO_CACHE;
        localWebSettings.domStorageEnabled = true;
        localWebSettings.databaseEnabled = true;
        webview_test.addJavascriptInterface(JavaScriptInterface(), "ngaObj");
        localWebSettings.userAgentString = "Nga_Official/" + "73001" + "(" + Build.MANUFACTURER + " " + Build.MODEL + ";" + "Android " + Build.VERSION.RELEASE + ") "
        webview_test.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                Log.e("TAG", ": $url | $message | $result");
                return super.onJsAlert(view, url, message, result)
            }
        }
        webview_test.loadUrl("https://bbs.nga.cn/nuke/account.html?login")

        webview_test.clearHistory()
    }

    internal inner class JavaScriptInterface() {


        @JavascriptInterface
        fun doAction(s: String, s1: String): String? {
            Log.e("TAG s:", s)
            Log.e("TAG s1:", s1)
            when (s) {
                "style" -> {
                    return "default"
                }
                "appid" -> {
                    return "1010"
                }
                "deviceid" -> return "android;" + UUID.randomUUID().toString()
                "checksum" -> {
                    val gosn = Gson()
                    val json = gosn.fromJson<JsonObject>(s1, JsonObject::class.java)
                    val uid = json.get("uid").asString
                    println("uid:" + uid)
                    val a = y.a(this@LoginActivity, uid)
                    Log.e("TAG checksum", ": $a");
                    return a
                }
                "loginSuccess" -> {
                    runBlocking(CommonPool) {
                        val moshi = Moshi.Builder().build().adapter(User::class.java)
                        val user = moshi.fromJson(s1)
                        if (user != null) {
                            user.id = 1L
                            AppDatabase
                                    .getInstance(applicationContext)
                                    .userDao().insert(user)
                        }
                        launch(UI){
                            toast("登陆成功")
                            finish()
                        }
                    }
                    return ""
                }
                else -> {
                    print("else")
                    return ""
                }

            }
        }

    }
}
