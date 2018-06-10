package org.gosky.nga.main

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonObject
import gov.pianzong.androidnga.jni.SignJni
import gov.pianzong.androidnga.jni.y
import kotlinx.android.synthetic.main.activity_web_view.*
import org.gosky.nga.R


class WebViewActivity : AppCompatActivity() {
    private val TAG = "WebViewActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        WebView.setWebContentsDebuggingEnabled(true);

        val localWebSettings = webview_test.getSettings()

        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setSupportZoom(true);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localWebSettings.setAllowFileAccess(true);
        localWebSettings.setDefaultTextEncodingName("GBK");
        localWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setCacheMode(2);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setDatabaseEnabled(true);
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

        val mD5KeyFormJNI = SignJni.getMD5KeyFormJNI(this, 1528542311.toString())
        Log.e(TAG, ": $mD5KeyFormJNI");
        "f4999a7ba380ab06515bb8c844560d40"
        "3e056d98095055525a919e1ffc075e2a"
    }

    internal inner class JavaScriptInterface() {


        @JavascriptInterface
        fun doAction(s: String, s1: String): String? {
            Log.e("TAG s:", s)
            Log.e("TAG s1:", s1)
            Toast.makeText(this@WebViewActivity, s + s1, Toast.LENGTH_SHORT).show()
            when (s) {
                "style" -> {
                    return "default"
                }

                "appid" -> {
                    return "1010"
                }
                "deviceid" -> return "android;AghFO8UF3kCmOW3RSbGtAlphIiF5HfJsSnaDto6mixx5"

                "checksum" -> {
                    val gosn = Gson()
                    val json = gosn.fromJson<JsonObject>(s1, JsonObject::class.java)
                    val uid = json.get("uid").asString
                    println("uid:" + uid)
                    val a = y.a(this@WebViewActivity, uid)
                    Log.e("TAG checksum", ": $a");
                    return a
                }
                else -> {
                    print("else")
                    return ""
                }

            }
        }

    }
}
