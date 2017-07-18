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
//                    .addHeader("host", "bbs.nga.cn")
//                    .addHeader("connection", "keep-alive")
//                    .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
//                    .addHeader("accept", "image/webp,image/apng,image/*,*/*;q=0.8")
                    .addHeader("referer", "https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui")
//                    .addHeader("accept-encoding", "gzip, deflate, br")
//                    .addHeader("accept-language", "zh-CN,zh;q=0.8")
//                    .addHeader("cookie", "UM_distinctid=15d0d5e51e0738-0db304f2c419c6-8383667-1fa400-15d0d5e51e1c1; CNZZDATA1261107569=351296727-1499166315-http%253A%252F%252Fbbs.ngacn.cc%252F%7C1499166315; __utma=240585808.2085683134.1500274707.1500274707.1500274707.1; __utmz=240585808.1500274707.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none); bbsmisccookies=%7B%22insad_refreshid%22%3A%7B0%3A%22/68014b3946d1b2ca086a8cbad6dc%22%2C1%3A1500879486%7D%2C%22pv_count_for_insad%22%3A%7B0%3A-44%2C1%3A1500310812%7D%2C%22insad_views%22%3A%7B0%3A1%2C1%3A1500310812%7D%7D; CNZZDATA1256638869=792539268-1500271524-http%253A%252F%252Fbbs.ngacn.cc%252F%7C1500271524; CNZZDATA30043604=cnzz_eid%3D1782946791-1499163294-%26ntime%3D1500272057; CNZZDATA30039253=cnzz_eid%3D973354512-1499164106-%26ntime%3D1500273149")
                    .addHeader("cache-control", "no-cache")
//                    .addHeader("postman-token", "30e569dd-1d1c-9f70-76b2-278a18c917c4")
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
                    .addHeader("host", "bbs.nga.cn")
                    .addHeader("connection", "keep-alive")
                    .addHeader("content-length", "103")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("origin", "https://bbs.nga.cn")
                    .addHeader("upgrade-insecure-requests", "1")
                    .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .addHeader("referer", "https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui")
                    .addHeader("accept-encoding", "gzip, deflate, br")
                    .addHeader("accept-language", "zh-CN,zh;q=0.8")
//                    .addHeader("cookie", "UM_distinctid=15d0d5e51e0738-0db304f2c419c6-8383667-1fa400-15d0d5e51e1c1; CNZZDATA1261107569=351296727-1499166315-http%253A%252F%252Fbbs.ngacn.cc%252F%7C1499166315; __utma=240585808.2085683134.1500274707.1500274707.1500274707.1; __utmz=240585808.1500274707.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none); bbsmisccookies=%7B%22insad_refreshid%22%3A%7B0%3A%22/68014b3946d1b2ca086a8cbad6dc%22%2C1%3A1500879486%7D%2C%22pv_count_for_insad%22%3A%7B0%3A-44%2C1%3A1500310812%7D%2C%22insad_views%22%3A%7B0%3A1%2C1%3A1500310812%7D%7D; CNZZDATA1256638869=792539268-1500271524-http%253A%252F%252Fbbs.ngacn.cc%252F%7C1500271524; CNZZDATA30043604=cnzz_eid%3D1782946791-1499163294-%26ntime%3D1500272057; CNZZDATA30039253=cnzz_eid%3D973354512-1499164106-%26ntime%3D1500273149; ngaPassportOid=1cac1d95fd7e7c7bda6928f44745a67e")
//                    .addHeader("postman-token", "028c2235-fdee-833b-9d9d-09e775a45ad0")
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
                    .addHeader("host", "bbs.nga.cn")
                    .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0")
                    .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .addHeader("accept-language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .addHeader("accept-encoding", "gzip, deflate")
//                    .addHeader("cookie", "bbsmisccookies=%7B%7D; ngacn0comUserInfo=%25B4%25F3%25C4%25A2%25B9%25BD%25B9%25BD%09%25E5%25A4%25A7%25E8%2598%2591%25E8%258F%2587%25E8%258F%2587%0939%0939%09%0910%0915765%094%090%090%0922_380; ngacn0comUserInfoCheck=2e7368f7537580ec9988e4ca48fc740d; ngacn0comInfoCheckTime=1500367361; ngaPassportUid=25944452; ngaPassportUrlencodedUname=%25B4%25F3%25C4%25A2%25B9%25BD%25B9%25BD; ngaPassportCid=Z8faorhcdddijfheljgl2anvolb13i5t5uta6ikn; lastvisit=1500367593; lastpath=/thread.php?fid=-7&page=1&lite=js&noprefix")
                    .addHeader("dnt", "1")
                    .addHeader("connection", "keep-alive")
                    .addHeader("upgrade-insecure-requests", "1")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "8e2f43d6-7d99-0c96-a3f1-ff18a7f50416")
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
//                    .addHeader("host", "bbs.nga.cn")
//                    .addHeader("connection", "keep-alive")
//                    .addHeader("content-length", "61")
//                    .addHeader("cache-control", "no-cache")
//                    .addHeader("origin", "https://bbs.nga.cn")
//                    .addHeader("upgrade-insecure-requests", "1")
//                    .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
//                    .addHeader("content-type", "application/x-www-form-urlencoded")
//                    .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .addHeader("referer", "https://bbs.nga.cn/nuke.php?__lib=login&__act=login_ui")
                    .addHeader("accept-encoding", "gzip, deflate, br")
                    .addHeader("accept-language", "zh-CN,zh;q=0.8")
//                    .addHeader("cookie", "bbsmisccookies=%7B%7D; lastvisit=1500367372; lastpath=/thread.php?fid=-7&page=1&lite=js&noprefix; ngacn0comUserInfo=%25B4%25F3%25C4%25A2%25B9%25BD%25B9%25BD%09%25E5%25A4%25A7%25E8%2598%2591%25E8%258F%2587%25E8%258F%2587%0939%0939%09%0910%0915765%094%090%090%0922_380; ngacn0comUserInfoCheck=2e7368f7537580ec9988e4ca48fc740d; ngacn0comInfoCheckTime=1500367361; ngaPassportUid=25944452; ngaPassportUrlencodedUname=%25B4%25F3%25C4%25A2%25B9%25BD%25B9%25BD; ngaPassportCid=Z8faorhcdddijfheljgl2anvolb13i5t5uta6ikn820f52224a4589ad543ebf8c91a2%22%2C1%3A1500965192%7D%2C%22pv_count_for_insad%22%3A%7B0%3A1%2C1%3A1500397264%7D%2C%22insad_views%22%3A%7B0%3A0%2C1%3A1500397264%7D%7D; CNZZDATA30043604=cnzz_eid%3D1782946791-1499163294-%26ntime%3D1500355081; CNZZDATA30039253=cnzz_eid%3D973354512-1499164106-%26ntime%3D1500358616; ngaPassportOid=059579d08a603a179e86c9c0ed290e88")
//                    .addHeader("postman-token", "949470f9-958a-45a4-5800-df6bffb9cb9d")
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
