package org.gosky.nga.data.entity;

import java.util.Map;

/**
 * @author guozhong
 * @date 2017/7/25
 */

public class TopicBean {

    private DataBean data;
    private String encode;
    private int time;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TopicBean{" +
                "data=" + data +
                ", encode='" + encode + '\'' +
                ", time=" + time +
                '}';
    }

    public static class DataBean {
        private CUBean __CU;
        private String __GLOBAL;
        private Map<String, UBean> __U;
        private Map<String, RBean> __R;
        private TBean __T;
        private int __R__ROWS;
        private int __R__ROWS_PAGE;
        private int __ROWS;

        public TBean get__T() {
            return __T;
        }

        public void set__T(TBean __T) {
            this.__T = __T;
        }

        public CUBean get__CU() {
            return __CU;
        }

        public void set__CU(CUBean __CU) {
            this.__CU = __CU;
        }

        public String get__GLOBAL() {
            return __GLOBAL;
        }

        public void set__GLOBAL(String __GLOBAL) {
            this.__GLOBAL = __GLOBAL;
        }

        public Map<String, UBean> get__U() {
            return __U;
        }

        public void set__U(Map<String, UBean> __U) {
            this.__U = __U;
        }

        public Map<String, RBean> get__R() {
            return __R;
        }

        public void set__R(Map<String, RBean> __R) {
            this.__R = __R;
        }

        public int get__R__ROWS() {
            return __R__ROWS;
        }

        public void set__R__ROWS(int __R__ROWS) {
            this.__R__ROWS = __R__ROWS;
        }

        public int get__R__ROWS_PAGE() {
            return __R__ROWS_PAGE;
        }

        public void set__R__ROWS_PAGE(int __R__ROWS_PAGE) {
            this.__R__ROWS_PAGE = __R__ROWS_PAGE;
        }

        public int get__ROWS() {
            return __ROWS;
        }

        public void set__ROWS(int __ROWS) {
            this.__ROWS = __ROWS;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "__CU=" + __CU +
                    ", __GLOBAL='" + __GLOBAL + '\'' +
                    ", __U=" + __U +
                    ", __R=" + __R +
                    ", __R__ROWS=" + __R__ROWS +
                    ", __R__ROWS_PAGE=" + __R__ROWS_PAGE +
                    ", __ROWS=" + __ROWS +
                    '}';
        }

        public static class CUBean {
            private int uid;
            private int group_bit;
            private String admincheck;
            private int rvrc;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getGroup_bit() {
                return group_bit;
            }

            public void setGroup_bit(int group_bit) {
                this.group_bit = group_bit;
            }

            public String getAdmincheck() {
                return admincheck;
            }

            public void setAdmincheck(String admincheck) {
                this.admincheck = admincheck;
            }

            public int getRvrc() {
                return rvrc;
            }

            public void setRvrc(int rvrc) {
                this.rvrc = rvrc;
            }

            @Override
            public String toString() {
                return "CUBean{" +
                        "uid=" + uid +
                        ", group_bit=" + group_bit +
                        ", admincheck='" + admincheck + '\'' +
                        ", rvrc=" + rvrc +
                        '}';
            }
        }

        public static class UBean {

            private int uid;
            private String username;
            private int credit;
            private String medal;
            private String reputation;
            private int groupid;
            private int memberid;
            private Object avatar;
            private int yz;
            private String site;
            private String honor;
            private int regdate;
            private String mute_time;
            private int postnum;
            private int rvrc;
            private int money;
            private int thisvisit;
            private String signature;
            private String nickname;
            private int bit_data;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getCredit() {
                return credit;
            }

            public void setCredit(int credit) {
                this.credit = credit;
            }

            public String getMedal() {
                return medal;
            }

            public void setMedal(String medal) {
                this.medal = medal;
            }

            public String getReputation() {
                return reputation;
            }

            public void setReputation(String reputation) {
                this.reputation = reputation;
            }

            public int getGroupid() {
                return groupid;
            }

            public void setGroupid(int groupid) {
                this.groupid = groupid;
            }

            public int getMemberid() {
                return memberid;
            }

            public void setMemberid(int memberid) {
                this.memberid = memberid;
            }

            public Object getAvatar() {
                return avatar;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

            public int getYz() {
                return yz;
            }

            public void setYz(int yz) {
                this.yz = yz;
            }

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public String getHonor() {
                return honor;
            }

            public void setHonor(String honor) {
                this.honor = honor;
            }

            public int getRegdate() {
                return regdate;
            }

            public void setRegdate(int regdate) {
                this.regdate = regdate;
            }

            public String getMute_time() {
                return mute_time;
            }

            public void setMute_time(String mute_time) {
                this.mute_time = mute_time;
            }

            public int getPostnum() {
                return postnum;
            }

            public void setPostnum(int postnum) {
                this.postnum = postnum;
            }

            public int getRvrc() {
                return rvrc;
            }

            public void setRvrc(int rvrc) {
                this.rvrc = rvrc;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public int getThisvisit() {
                return thisvisit;
            }

            public void setThisvisit(int thisvisit) {
                this.thisvisit = thisvisit;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getBit_data() {
                return bit_data;
            }

            public void setBit_data(int bit_data) {
                this.bit_data = bit_data;
            }

            @Override
            public String toString() {
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
                        '}';
            }
        }

        public static class RBean {

            /**
             * content : 原文链接 &nbsp; &nbsp;[url]http://tech.sina.com.cn/mobile/n/n/2017-07-24/doc-ifyihrit1264230.shtml?cre=tianyi&amp;mod=pctech&amp;loc=23&amp;r=0&amp;doct=0&amp;rfunc=44&amp;tj=none&amp;s=0&amp;tr=63[/url]<br/><br/>[quote] 距离MIUI 9亮相还有两天时间，但MIUI官方公众号却为满足用户开了一场“超前发布会”，提前公布了MIUI 9的诸多新变化。首先，MIUI 9共有四款主题，包含三套新主题，分别为青春《无界》、时尚《幻彩》、商务《炫黑》。<br/><br/>[img]./mon_201707/25/c4Qho6-2180KqT1kSfa-dc.jpg.thumb.jpg[/img]<br/>[color=skyblue]商务《炫黑》主题[/color]<br/>  另外，MIUI官方表示，MIUI 9第一批适配机型为小米6和红米Note 4X，第二批适配小米5、小米MIX、小米Note 2等主要热门机型，其他机型将按批次陆续适配。而仍有500万用户的小米2/2S也将适配MIUI 9，但时间稍晚会放在第三批进行适配。<br/><br/>  功能方面，MIUI 9锁屏左一屏采用新的设计，锁屏时向右滑动可以看到。锁屏状态下屏幕向右滑动就可以找到手电筒、米家、万能遥控器、MI Pay、小米公交共5个快捷功能入口。而MIUI分屏模式将成为MIUI 9标准功能，基于Android 7.0及以上版本的MIUI系统，将支持分屏模式。<br/><br/>[img]./mon_201707/25/c4Qho6-kpukKkT1kSfa-r6.jpg.thumb.jpg[/img]<br/>[color=skyblue]锁屏左一屏采用新的设计[/color]<br/><br/>  MIUI 9的亮点是对系统功能进行了全面的梳理。它对一些非刚需、极低频、且用户量少的功能进行了适度精简和优化，共精简和优化超过50项系统功能，取消了云名片和来电秀功能、儿童模式等等。<br/><br/>  值得一提的是，为了更流畅更稳定更省电，MIUI 9采用内存反碎片优化、动态IO资源管控技术。但这方面，官方介绍的比较少，想必会成为7月26日发布会重点讲解的地方，各位米粉拭目以待吧。[/quote]
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

            private String content;
            private String alterinfo;
            private int tid;
            private int score;
            private int score_2;
            private String postdate;
            private int authorid;
            private String subject;
            private int type;
            private int fid;
            private int pid;
            private int recommend;
            private int lou;
            private String content_length;
            private Map<String, AttachsBean> attachs;
            private int postdatetimestamp;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAlterinfo() {
                return alterinfo;
            }

            public void setAlterinfo(String alterinfo) {
                this.alterinfo = alterinfo;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getScore_2() {
                return score_2;
            }

            public void setScore_2(int score_2) {
                this.score_2 = score_2;
            }

            public String getPostdate() {
                return postdate;
            }

            public void setPostdate(String postdate) {
                this.postdate = postdate;
            }

            public int getAuthorid() {
                return authorid;
            }

            public void setAuthorid(int authorid) {
                this.authorid = authorid;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public int getRecommend() {
                return recommend;
            }

            public void setRecommend(int recommend) {
                this.recommend = recommend;
            }

            public int getLou() {
                return lou;
            }

            public void setLou(int lou) {
                this.lou = lou;
            }

            public String getContent_length() {
                return content_length;
            }

            public void setContent_length(String content_length) {
                this.content_length = content_length;
            }

            public Map<String, AttachsBean> getAttachs() {
                return attachs;
            }

            public void setAttachs(Map<String, AttachsBean> attachs) {
                this.attachs = attachs;
            }

            public int getPostdatetimestamp() {
                return postdatetimestamp;
            }

            public void setPostdatetimestamp(int postdatetimestamp) {
                this.postdatetimestamp = postdatetimestamp;
            }

            @Override
            public String toString() {
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
                        '}';
            }

            public static class AttachsBean {

                private String attachurl;
                private int size;
                private String type;
                private int subid;
                private String url_utf8_org_name;
                private String dscp;
                private String path;
                private String name;
                private String ext;
                private String thumb;

                public String getAttachurl() {
                    return attachurl;
                }

                public void setAttachurl(String attachurl) {
                    this.attachurl = attachurl;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getSubid() {
                    return subid;
                }

                public void setSubid(int subid) {
                    this.subid = subid;
                }

                public String getUrl_utf8_org_name() {
                    return url_utf8_org_name;
                }

                public void setUrl_utf8_org_name(String url_utf8_org_name) {
                    this.url_utf8_org_name = url_utf8_org_name;
                }

                public String getDscp() {
                    return dscp;
                }

                public void setDscp(String dscp) {
                    this.dscp = dscp;
                }

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getExt() {
                    return ext;
                }

                public void setExt(String ext) {
                    this.ext = ext;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                @Override
                public String toString() {
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
                            '}';
                }
            }
        }

        public static class TBean {
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

            private int fid;
            private int tid;
            private String topic_misc;
            private String subject;
            private int locked;
            private int recommend;
            private String quote_to;
            private int quote_from;
            private int type;
            private int replies;
            private int authorid;
            private int postdate;
            private int lastpost;
            private String author;
            private String lastposter;
            private int digest;
            private int lastmodify;
            private int tpid;
            private TopicMiscVarBean topic_misc_var;
            private PostMiscVarBean post_misc_var;
            private int this_visit_rows;
            private String view_count;

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public String getTopic_misc() {
                return topic_misc;
            }

            public void setTopic_misc(String topic_misc) {
                this.topic_misc = topic_misc;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public int getLocked() {
                return locked;
            }

            public void setLocked(int locked) {
                this.locked = locked;
            }

            public int getRecommend() {
                return recommend;
            }

            public void setRecommend(int recommend) {
                this.recommend = recommend;
            }

            public String getQuote_to() {
                return quote_to;
            }

            public void setQuote_to(String quote_to) {
                this.quote_to = quote_to;
            }

            public int getQuote_from() {
                return quote_from;
            }

            public void setQuote_from(int quote_from) {
                this.quote_from = quote_from;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getReplies() {
                return replies;
            }

            public void setReplies(int replies) {
                this.replies = replies;
            }

            public int getAuthorid() {
                return authorid;
            }

            public void setAuthorid(int authorid) {
                this.authorid = authorid;
            }

            public int getPostdate() {
                return postdate;
            }

            public void setPostdate(int postdate) {
                this.postdate = postdate;
            }

            public int getLastpost() {
                return lastpost;
            }

            public void setLastpost(int lastpost) {
                this.lastpost = lastpost;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getLastposter() {
                return lastposter;
            }

            public void setLastposter(String lastposter) {
                this.lastposter = lastposter;
            }

            public int getDigest() {
                return digest;
            }

            public void setDigest(int digest) {
                this.digest = digest;
            }

            public int getLastmodify() {
                return lastmodify;
            }

            public void setLastmodify(int lastmodify) {
                this.lastmodify = lastmodify;
            }

            public int getTpid() {
                return tpid;
            }

            public void setTpid(int tpid) {
                this.tpid = tpid;
            }

            public TopicMiscVarBean getTopic_misc_var() {
                return topic_misc_var;
            }

            public void setTopic_misc_var(TopicMiscVarBean topic_misc_var) {
                this.topic_misc_var = topic_misc_var;
            }

            public PostMiscVarBean getPost_misc_var() {
                return post_misc_var;
            }

            public void setPost_misc_var(PostMiscVarBean post_misc_var) {
                this.post_misc_var = post_misc_var;
            }

            public int getThis_visit_rows() {
                return this_visit_rows;
            }

            public void setThis_visit_rows(int this_visit_rows) {
                this.this_visit_rows = this_visit_rows;
            }

            public String getView_count() {
                return view_count;
            }

            public void setView_count(String view_count) {
                this.view_count = view_count;
            }

            public static class TopicMiscVarBean {
            }

            public static class PostMiscVarBean {
            }
        }

    }
}
