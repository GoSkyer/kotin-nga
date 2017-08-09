package org.gosky.nga.data.entity

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by Admin on 2017/7/31.
 */

class BoardBean : Serializable {
    var code: Int = 0
    var msg: String? = null
    var guest_token: String? = null
    var forum_icon_pre: String? = null
    var result: List<ResultBean>? = null

    override fun toString(): String {
        return "BoardBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", guest_token='" + guest_token + '\'' +
                ", forum_icon_pre='" + forum_icon_pre + '\'' +
                ", result=" + result +
                '}'
    }

    class ResultBean : Serializable {
        override fun toString(): String {
            return "ResultBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", groups=" + groups +
                    '}'
        }

        var id: Int = 0
        var name: String? = null
        var groups: List<GroupsBean>? = null

        class GroupsBean : Serializable {
            override fun toString(): String {
                return "GroupsBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", info='" + info + '\'' +
                        ", forums=" + forums +
                        '}'
            }

            var id: Int = 0
            var name: String? = null
            var info: String? = null
            var forums: ArrayList<ForumsBean>? = null

            class ForumsBean : Serializable {
                override fun toString(): String {
                    return "ForumsBean{" +
                            "id=" + id +
                            ", name='" + name + '\'' +
                            ", info='" + info + '\'' +
                            ", icon='" + icon + '\'' +
                            ", is_forumlist=" + isIs_forumlist +
                            ", top_title='" + top_title + '\'' +
                            ", top_opentype=" + top_opentype +
                            ", top_opendata='" + top_opendata + '\'' +
                            ", forums=" + forums +
                            '}'
                }

                var id: Int = 0
                var name: String? = null
                var info: String? = null
                var icon: String? = null
                var isIs_forumlist: Boolean = false
                var top_title: String? = null
                var top_opentype: Int = 0
                var top_opendata: String? = null
                var forums: ArrayList<ForumsBean>? = null
            }
        }
    }
}
