package org.gosky.nga.ui.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_test.*
import okhttp3.*
import okhttp3.internal.http.RealResponseBody
import okio.GzipSource
import okio.Okio
import org.gosky.nga.R
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class TestActivity : AppCompatActivity() {

    var ivTest: ImageView? = null
    val client = OkHttpClient().newBuilder().cookieJar(object : CookieJar {
        private val cookieStore = HashMap<String, List<Cookie>>()

        override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
            cookieStore.put(url.host(), cookies)
            Log.d("cookie", ": " + cookies.toString());
        }

        override fun loadForRequest(url: HttpUrl): List<Cookie> {
            val cookies = cookieStore[url.host()]
            Log.d("requestcookie", ": " + cookies);
            return cookies ?: ArrayList<Cookie>()
        }
    }).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_test)
        initView()
        doAsync {
            val request = Request.Builder()
                    .url("https://bbs.nga.cn/login_check_code.php?id=_0.2703636995034375")
                    .get()
                    .addHeader("referer", "https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui")
                    .addHeader("cache-control", "no-cache")
                    .build()

            val response = client.newCall(request).execute()
            val decodeStream = BitmapFactory.decodeStream(response.body()?.byteStream())
            uiThread {
                //                println(response.body()?.byteStream().toString())
                ivTest?.setImageBitmap(decodeStream)
            }
        }




        btn_biu.setOnClickListener {
            login(et_code.text.toString())
        }
        btn_get.setOnClickListener {
            getInfo()
        }
        btn_cookie.setOnClickListener {
            getCookie()
        }
    }

    private fun initView() {
        ivTest = findViewById(R.id.iv_test) as ImageView
    }

    private fun login(code: String) {
        doAsync {
            val mediaType = MediaType.parse("application/x-www-form-urlencoded")
            val body = RequestBody.create(mediaType, "name=%B4%F3%C4%A2%B9%BD%B9%BD&type=name&password=hunji_wisdom&rid=_0.2703636995034375&captcha=$code&qrkey=")
            val request = Request.Builder()
                    .url("https://bbs.nga.cn/nuke.php?__lib=login&__act=login&raw=3")
                    .post(body)
                    .addHeader("referer", "https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui")
                    .addHeader("accept-encoding", "gzip, deflate, br")
                    .addHeader("accept-language", "zh-CN,zh;q=0.8")
                    .build()

            val response = client.newCall(request).execute()

            val response1 = gbk2utf8(unzip(response))
            val string = response1.body()?.string()
//            Log.d("cookie", ": " + response1.body());
            uiThread {
                //                print(response.body().toString())
                Log.d("TAG", ": " + string);
            }
        }
    }

    private fun getInfo() {
        doAsync {
            val request = Request.Builder()
                    .url("http://bbs.nga.cn/thread.php?fid=-7&page=1&lite=js&noprefix")
                    .get()
                    .addHeader("accept-language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .addHeader("accept-encoding", "gzip, deflate")
                    .build()

            val response = gbk2utf8(unzip(client.newCall(request).execute()))
            val string = response.body()?.string()
            uiThread {
                //                print(response.body().toString())
                Log.d("TAG", ": " + string);
            }
        }
    }

    private fun getCookie() {
        doAsync {
            /**
             * 参数 uid，cid是在登陆成功后返回结果中获取的
             */
            val mediaType = MediaType.parse("application/x-www-form-urlencoded")
            val body = RequestBody.create(mediaType, "uid=25944452&cid=Z8faorhcdddijfheljgl2anvolb13i5t5uta6ikn&to=")
            val request = Request.Builder()
                    .url("https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui%2Fnuke.php%3F__lib%3Dlogin&__act=set_cookie&nojump=1&raw=3&to=https%3A%2F%2Fbbs.nga.cn%2Fnuke.php%3F__lib%3Dlogin%26__act%3Dset_cookie_complete%26raw%3D3")
                    .post(body)
                    .addHeader("referer", "https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui")
                    .addHeader("accept-encoding", "gzip, deflate, br")
                    .addHeader("accept-language", "zh-CN,zh;q=0.8")
                    .build()

            val response = gbk2utf8(unzip(client.newCall(request).execute()))
            val string = response.body()?.string()
            Log.d("heads", ": " + response.headers().toString());
            uiThread {
                val s = string?.split("<script>")?.get(1)
                val json = s?.split("</script>")?.get(0)?.replace("window.script_muti_get_var_store=", "")
                Log.d("getCookie", ": " + string);
                val j: JsonObject = JsonParser().parse(json).getAsJsonObject()
                val asJsonObject = j.getAsJsonObject("data")
                val url1 = asJsonObject.get("0").asString
                val url2 = asJsonObject.get("1").asString
                val url3 = asJsonObject.get("2").asString
                Log.d("url1", ": " + url1);
                Log.d("url2", ": " + url2);
                Log.d("url3", ": " + url3);
                doAsync {
                    setCookie(url1, url2, url3)
                }
            }
        }
    }


    private fun setCookie(url1: String, url2: String, url3: String) {
        val request1 = Request.Builder()
                .url(url1)
                .get()
                .build()
        val request2 = Request.Builder()
                .url(url2)
                .get()
                .build()
        val request3 = Request.Builder()
                .url(url3)
                .get()
                .build()

        val response1 = client.newCall(request1).execute()
        val response2 = client.newCall(request2).execute()
        val response3 = client.newCall(request3).execute()
        println(response1.body()?.string())
        unzip(response2)
        unzip(response3)
    }


    @Throws(IOException::class)
    private fun unzip(response: Response): Response {

        if (response.body() == null) {
            return response
        }

        val responseBody = GzipSource(response.body()!!.source())
        val strippedHeaders = response.headers().newBuilder()
                .removeAll("Content-Encoding")
                .removeAll("Content-Length")
                .build()
        return response.newBuilder()
                .headers(strippedHeaders)
                .body(RealResponseBody(strippedHeaders, Okio.buffer(responseBody)))
                .build()
    }

    @Throws(IOException::class)
    private fun gbk2utf8(response: Response): Response {
        if (response.body() == null)
            return response
        val `in` = response.body()!!.byteStream()
        val reader = BufferedReader(InputStreamReader(`in`, "GBK"))
        //        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        val sb = StringBuilder()
        var line: String? = null
        while (reader.readLine().apply { line = this } != null) {
            sb.append(line)
            sb.append("\n")
        }
        val s = sb.toString()
        Log.d("okhttp", s)
        val responseBody = response.body()
        val contentType = responseBody!!.contentType()
        val body = ResponseBody.create(contentType, s)
        return response.newBuilder()
                .body(body)
                .build()
    }
}
