package org.gosky.nga.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_test.*
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import org.gosky.nga.R
import java.util.*


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
        val originalStr5 = "[table][tr][td]Boss[/td][td][align=center][b]亚洲[/b](6月29日6:00开放)[/align][/td][td][align=center][b]时间[/b][/align][/td][td][align=center][b]欧服[/b](6月28日15:00开放)[/align][/td][td][align=center][b]时间[/b][/align][/td][td][align=center][b]美服[/b][/align][/td][td][align=center][b]时间[/b](6月27日23:00开放)[/align][/td][/tr][tr][td]H基尔加丹[/td][td][color=red]阿尔法 @CN-埃德萨拉[/color][/td][td]6月22日17:30[/td][td][color=blue]Libertad @EU-Ravencrest[/color][/td][td]6月22日0:07[/td][td][b][color=red]Nurfed @US-Tichondrius[/color][/b][/td][td]6月21日12:47[/td][/tr][tr][td]M格罗斯[/td][td][color=red]启迪 @CN-红龙军团[/td][td]6月29日8:27[/td][td][color=red]Exorsus @EU(RU)-Howling Fjord[/color][/td][td]6月28日15:20[/td][td][b][color=blue]Easy @US-Aerie Peak[/color][/b][/td][td]6月27日23:20[/td][/tr][tr][td]M恶魔审判庭[/td][td][color=red]启迪 @CN-红龙军团[/td][td]6月29日9:15[/td][td][color=red]Exorsus @EU(RU)-Howling Fjord[/color][/td][td]6月28日15:29[/td][td][b][color=blue]Easy @US-Aerie Peak[/color][/b][/td][td]6月27日23:43[/td][/tr][tr][td]M哈亚坦[/td][td][color=red]启迪 @CN-红龙军团[/td][td]6月29日8:53[/td][td][color=red]Exorsus @EU(RU)-Howling Fjord[/color][/td][td]6月28日15:41[/td][td][b][color=red]Big Dumb Guild @US-Illidan[/color][/b][/td][td]6月27日23:41[/td][/tr][tr][td]M月之姐妹[/td][td][color=red]A Stars @CN-燃烧之刃[/color][/td][td]6月29日13:48[/td][td][color=red]Exorsus @EU(RU)-Howling Fjord[/color][/td][td]6月28日18:27[/td][td][b][color=red]Big Dumb Guild @US-Illidan[/color][/b][/td][td]6月28日4:07[/td][/tr][tr][td]M主母萨丝琳[/td][td][color=red]阿尔法 @CN-埃德萨拉[/color][/td][td]6月30日22:48[/td][td][b][color=red]Method @EU-Tarren Mill[/color][/b][/td][td]6月29日1:17[/td][td][color=red]Limit @US-Illidan[/color][/td][td]6月29日11:55[/td][/tr][tr][td]M绝望的聚合体[/td][td][color=red]A Stars @CN-燃烧之刃[/color][/td][td]6月29日16:51[/td][td][color=red]Method @EU-Tarren Mill[/color][/td][td]6月28日19:37[/td][td][b][color=red]Big Dumb Guild @US-Illidan[/color][/b][/td][td]6月28日13:15[/td][/tr][tr][td]M戒卫侍女[/td][td][color=red]阿尔法 @CN-埃德萨拉[/color][/td][td]7月1日3:10[/td][td][b][color=red]Method @EU-Tarren Mill[/color][/b][/td][td]6月29日16:45[/td][td][color=red]Limit @US-Illidan[/color][/td][td]6月30日9:50[/td][/tr][tr][td]M堕落的化身[/td][td][color=red]阿尔法 @CN-埃德萨拉[/color][/td][td]7月11日 7:38[/td][td][b][color=red]Method @EU-Tarren Mill[/color][/b][/td]   [td]7月5日0:30[/td][td][color=blue]Easy @US-Aerie Peak[/color][/td][td]7月16日4:55[/td][/tr][tr][td]M基尔加丹[/td][td][color=red]AFK R @KR-Azshara[/color][/td][td]7月28日2:13[/td][td][b][color=red]Method @EU-Tarren Mill[/color][/b][/td][td]7月16日20:01[/td][td][color=red]Limit @US-Illidan[/color][/td][td]8月5日8:02[/td][/tr][/table]"
        frtv.setText(originalStr5)
    }
}
