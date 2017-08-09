package org.gosky.nga.data.entity

/**
 * @author guozhong
 * *
 * @date 2017/7/25
 */

class TopicBean {

    var data: DataBean? = null
    var encode: String? = null
    var time: Int = 0

    override fun toString(): String {
        return "TopicBean{" +
                "data=" + data +
                ", encode='" + encode + '\'' +
                ", time=" + time +
                '}'
    }

    class DataBean {
        var __CU: CUBean? = null
        var __GLOBAL: String? = null
        var __U: Map<String, UBean>? = null
        var __R: Map<String, RBean>? = null
        var __T: TBean? = null
        var __R__ROWS: Int = 0
        var __R__ROWS_PAGE: Int = 0
        var __ROWS: Int = 0

        override fun toString(): String {
            return "DataBean{" +
                    "__CU=" + __CU +
                    ", __GLOBAL='" + __GLOBAL + '\'' +
                    ", __U=" + __U +
                    ", __R=" + __R +
                    ", __R__ROWS=" + __R__ROWS +
                    ", __R__ROWS_PAGE=" + __R__ROWS_PAGE +
                    ", __ROWS=" + __ROWS +
                    '}'
        }

        class CUBean {
            var uid: Int = 0
            var group_bit: Int = 0
            var admincheck: String? = null
            var rvrc: Int = 0

            override fun toString(): String {
                return "CUBean{" +
                        "uid=" + uid +
                        ", group_bit=" + group_bit +
                        ", admincheck='" + admincheck + '\'' +
                        ", rvrc=" + rvrc +
                        '}'
            }
        }

        class UBean {

            var uid: Int = 0
            var username: String? = null
            var credit: Int = 0
            var medal: String? = null
            var reputation: String? = null
            var groupid: Int = 0
            var memberid: Int = 0
            var avatar: Any? = null
            var yz: Int = 0
            var site: String? = null
            var honor: String? = null
            var regdate: Int = 0
            var mute_time: String? = null
            var postnum: Int = 0
            var rvrc: Int = 0
            var money: Int = 0
            var thisvisit: Int = 0
            var signature: String? = null
            var nickname: String? = null
            var bit_data: Int = 0

            override fun toString(): String {
                return "UBean{" +
                        "uid=" + uid +
                        ", username='" + username + '\'' +
                        ", credit=" + credit +
                        ", medal='" + medal + '\'' +
                        ", reputation='" + reputation + '\'' +
                        ", groupid=" + groupid +
                        ", memberid=" + memberid +
                        ", avatar=" + avatar +
                        ", yz=" + yz +
                        ", site='" + site + '\'' +
                        ", honor='" + honor + '\'' +
                        ", regdate=" + regdate +
                        ", mute_time='" + mute_time + '\'' +
                        ", postnum=" + postnum +
                        ", rvrc=" + rvrc +
                        ", money=" + money +
                        ", thisvisit=" + thisvisit +
                        ", signature='" + signature + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", bit_data=" + bit_data +
                        '}'
            }
        }

        class RBean {

            /**
             * content : 原文链接 &nbsp; &nbsp;[url]http://tech.sina.com.cn/mobile/n/n/2017-07-24/doc-ifyihrit1264230.shtml?cre=tianyi&amp;mod=pctech&amp;loc=23&amp;r=0&amp;doct=0&amp;rfunc=44&amp;tj=none&amp;s=0&amp;tr=63[/url]<br></br><br></br>[quote] 距离MIUI 9亮相还有两天时间，但MIUI官方公众号却为满足用户开了一场“超前发布会”，提前公布了MIUI 9的诸多新变化。首先，MIUI 9共有四款主题，包含三套新主题，分别为青春《无界》、时尚《幻彩》、商务《炫黑》。<br></br><br></br>[img]./mon_201707/25/c4Qho6-2180KqT1kSfa-dc.jpg.thumb.jpg[/img]<br></br>[color=skyblue]商务《炫黑》主题[/color]<br></br>  另外，MIUI官方表示，MIUI 9第一批适配机型为小米6和红米Note 4X，第二批适配小米5、小米MIX、小米Note 2等主要热门机型，其他机型将按批次陆续适配。而仍有500万用户的小米2/2S也将适配MIUI 9，但时间稍晚会放在第三批进行适配。<br></br><br></br>  功能方面，MIUI 9锁屏左一屏采用新的设计，锁屏时向右滑动可以看到。锁屏状态下屏幕向右滑动就可以找到手电筒、米家、万能遥控器、MI Pay、小米公交共5个快捷功能入口。而MIUI分屏模式将成为MIUI 9标准功能，基于Android 7.0及以上版本的MIUI系统，将支持分屏模式。<br></br><br></br>[img]./mon_201707/25/c4Qho6-kpukKkT1kSfa-r6.jpg.thumb.jpg[/img]<br></br>[color=skyblue]锁屏左一屏采用新的设计[/color]<br></br><br></br>  MIUI 9的亮点是对系统功能进行了全面的梳理。它对一些非刚需、极低频、且用户量少的功能进行了适度精简和优化，共精简和优化超过50项系统功能，取消了云名片和来电秀功能、儿童模式等等。<br></br><br></br>  值得一提的是，为了更流畅更稳定更省电，MIUI 9采用内存反碎片优化、动态IO资源管控技术。但这方面，官方介绍的比较少，想必会成为7月26日发布会重点讲解的地方，各位米粉拭目以待吧。[/quote]
             * alterinfo :
             * tid : 12099030
             * score : 3
             * score_2 : 7
             * postdate : 2017-07-25 10:17
             * authorid : 40074371
             * subject : [IT新闻]小米MIUI 9系统提前发布 为流畅采用了黑科技？
             * type : 73728
             * fid : 436
             * pid : 0
             * recommend : 0
             * lou : 0
             * content_length : 184
             * attachs : {"0":{"attachurl":"mon_201707/25/c4Qho6-kpukKkT1kSfa-r6.jpg","size":21,"type":"img","subid":0,"url_utf8_org_name":"2%2ejpg","dscp":"","path":"mon_201707/25","name":"c4Qho6-kpukKkT1kSfa-r6.jpg","ext":"jpg","thumb":56},"1":{"attachurl":"mon_201707/25/c4Qho6-2180KqT1kSfa-dc.jpg","size":26,"type":"img","subid":1,"url_utf8_org_name":"1%2ejpg","dscp":"","path":"mon_201707/25","name":"c4Qho6-2180KqT1kSfa-dc.jpg","ext":"jpg","thumb":56}}
             * postdatetimestamp : 1500949066
             */

            var content: String? = null
            var alterinfo: String? = null
            var tid: Int = 0
            var score: Int = 0
            var score_2: Int = 0
            var postdate: String? = null
            var authorid: Int = 0
            var subject: String? = null
            var type: Int = 0
            var fid: Int = 0
            var pid: Int = 0
            var recommend: Int = 0
            var lou: Int = 0
            var content_length: String? = null
            var attachs: Map<String, AttachsBean>? = null
            var postdatetimestamp: Int = 0

            override fun toString(): String {
                return "RBean{" +
                        "content='" + content + '\'' +
                        ", alterinfo='" + alterinfo + '\'' +
                        ", tid=" + tid +
                        ", score=" + score +
                        ", score_2=" + score_2 +
                        ", postdate='" + postdate + '\'' +
                        ", authorid=" + authorid +
                        ", subject='" + subject + '\'' +
                        ", type=" + type +
                        ", fid=" + fid +
                        ", pid=" + pid +
                        ", recommend=" + recommend +
                        ", lou=" + lou +
                        ", content_length=" + content_length +
                        ", attachs=" + attachs +
                        ", postdatetimestamp=" + postdatetimestamp +
                        '}'
            }

            class AttachsBean {

                var attachurl: String? = null
                var size: Int = 0
                var type: String? = null
                var subid: Int = 0
                var url_utf8_org_name: String? = null
                var dscp: String? = null
                var path: String? = null
                var name: String? = null
                var ext: String? = null
                var thumb: String? = null

                override fun toString(): String {
                    return "AttachsBean{" +
                            "attachurl='" + attachurl + '\'' +
                            ", size=" + size +
                            ", type='" + type + '\'' +
                            ", subid=" + subid +
                            ", url_utf8_org_name='" + url_utf8_org_name + '\'' +
                            ", dscp='" + dscp + '\'' +
                            ", path='" + path + '\'' +
                            ", name='" + name + '\'' +
                            ", ext='" + ext + '\'' +
                            ", thumb=" + thumb +
                            '}'
                }
            }
        }

        class TBean {
            /**
             * fid : 476
             * tid : 9460053
             * topic_misc : AQAAACA
             * subject : [前瞻剧透] [游记] 牧师职业大厅战役全览------预言，拱卫圣光
             * locked : 0
             * recommend : 0
             * quote_to :
             * quote_from : 9460045
             * type : 512
             * replies : 134
             * authorid : 1035719
             * postdate : 1465917972
             * lastpost : 1500509172
             * author : Enddark
             * lastposter : Crawling_in
             * digest : 0
             * lastmodify : 1500509172
             * tpid : 0
             * topic_misc_var : {"1":32}
             * post_misc_var : {}
             * this_visit_rows : 1
             * view_count :
             */

            var fid: Int = 0
            var tid: Int = 0
            var topic_misc: String? = null
            var subject: String? = null
            var locked: Int = 0
            var recommend: Int = 0
            var quote_to: String? = null
            var quote_from: Int = 0
            var type: Int = 0
            var replies: Int = 0
            var authorid: Int = 0
            var postdate: Int = 0
            var lastpost: Int = 0
            var author: String? = null
            var lastposter: String? = null
            var digest: Int = 0
            var lastmodify: Int = 0
            var tpid: Int = 0
            var topic_misc_var: TopicMiscVarBean? = null
            var post_misc_var: PostMiscVarBean? = null
            var this_visit_rows: Int = 0
            var view_count: String? = null

            class TopicMiscVarBean

            class PostMiscVarBean
        }

    }
}
