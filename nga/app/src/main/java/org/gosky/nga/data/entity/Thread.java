package org.gosky.nga.data.entity;

/**
 * @author guozhong
 * @date 2017/6/23
 */

public class Thread {

    private int tid;
    private int fid;
    private int quote_from;
    private String quote_to;
    private int icon;
    private String topic_misc;
    private String author;
    private int authorid;
    private String subject;
    private int type;
    private int postdate;
    private int lastpost;
    private String lastposter;
    private int replies;
    private int lastmodify;
    private int recommend;
    private String tpcurl;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getQuote_from() {
        return quote_from;
    }

    public void setQuote_from(int quote_from) {
        this.quote_from = quote_from;
    }

    public String getQuote_to() {
        return quote_to;
    }

    public void setQuote_to(String quote_to) {
        this.quote_to = quote_to;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTopic_misc() {
        return topic_misc;
    }

    public void setTopic_misc(String topic_misc) {
        this.topic_misc = topic_misc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getLastposter() {
        return lastposter;
    }

    public void setLastposter(String lastposter) {
        this.lastposter = lastposter;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(int lastmodify) {
        this.lastmodify = lastmodify;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getTpcurl() {
        return tpcurl;
    }

    public void setTpcurl(String tpcurl) {
        this.tpcurl = tpcurl;
    }
}
