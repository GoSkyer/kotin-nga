package org.gosky.nga.data.entity

/**
 * @author guozhong
 * *
 * @date 2017/6/23
 */

class ThreadBean {

    var tid: Int = 0
    var fid: Int = 0
    var quote_from: Int = 0
    var quote_to: String? = null
    var icon: Int = 0
    var topic_misc: String? = null
    var author: String? = null
    var authorid: String? = null
    var subject: String? = null
    var type: Int = 0
    var postdate: Int = 0
    var lastpost: Int = 0
    var lastposter: String? = null
    var replies: Int = 0
    var lastmodify: Int = 0
    var recommend: Int = 0
    var tpcurl: String? = null

    override fun toString(): String {
        return "ThreadBean{" +
                "tid=" + tid +
                ", fid=" + fid +
                ", quote_from=" + quote_from +
                ", quote_to='" + quote_to + '\'' +
                ", icon=" + icon +
                ", topic_misc='" + topic_misc + '\'' +
                ", author='" + author + '\'' +
                ", authorid=" + authorid +
                ", subject='" + subject + '\'' +
                ", type=" + type +
                ", postdate=" + postdate +
                ", lastpost=" + lastpost +
                ", lastposter='" + lastposter + '\'' +
                ", replies=" + replies +
                ", lastmodify=" + lastmodify +
                ", recommend=" + recommend +
                ", tpcurl='" + tpcurl + '\'' +
                '}'
    }
}
