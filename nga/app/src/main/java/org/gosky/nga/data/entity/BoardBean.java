package org.gosky.nga.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/7/31.
 */

public class BoardBean implements Serializable{
    private int code;
    private String msg;
    private String guest_token;
    private String forum_icon_pre;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "BoardBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", guest_token='" + guest_token + '\'' +
                ", forum_icon_pre='" + forum_icon_pre + '\'' +
                ", result=" + result +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getGuest_token() {
        return guest_token;
    }

    public void setGuest_token(String guest_token) {
        this.guest_token = guest_token;
    }

    public String getForum_icon_pre() {
        return forum_icon_pre;
    }

    public void setForum_icon_pre(String forum_icon_pre) {
        this.forum_icon_pre = forum_icon_pre;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        @Override
        public String toString() {
            return "ResultBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", groups=" + groups +
                    '}';
        }

        private int id;
        private String name;
        private List<GroupsBean> groups;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<GroupsBean> getGroups() {
            return groups;
        }

        public void setGroups(List<GroupsBean> groups) {
            this.groups = groups;
        }

        public static class GroupsBean implements  Serializable{
            @Override
            public String toString() {
                return "GroupsBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", info='" + info + '\'' +
                        ", forums=" + forums +
                        '}';
            }

            private int id;
            private String name;
            private String info;
            private ArrayList<ForumsBean> forums;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public ArrayList<ForumsBean> getForums() {
                return forums;
            }

            public void setForums(ArrayList<ForumsBean> forums) {
                this.forums = forums;
            }

            public static class ForumsBean implements Serializable{
                @Override
                public String toString() {
                    return "ForumsBean{" +
                            "id=" + id +
                            ", name='" + name + '\'' +
                            ", info='" + info + '\'' +
                            ", icon='" + icon + '\'' +
                            ", is_forumlist=" + is_forumlist +
                            ", top_title='" + top_title + '\'' +
                            ", top_opentype=" + top_opentype +
                            ", top_opendata='" + top_opendata + '\'' +
                            ", forums=" + forums +
                            '}';
                }

                private int id;
                private String name;
                private String info;
                private String icon;
                private boolean is_forumlist;
                private String top_title;
                private int top_opentype;
                private String top_opendata;
                private ArrayList<ForumsBean> forums;

                public ArrayList<ForumsBean> getForums() {
                    return forums;
                }

                public void setForums(ArrayList<ForumsBean> forums) {
                    this.forums = forums;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public boolean isIs_forumlist() {
                    return is_forumlist;
                }

                public void setIs_forumlist(boolean is_forumlist) {
                    this.is_forumlist = is_forumlist;
                }

                public String getTop_title() {
                    return top_title;
                }

                public void setTop_title(String top_title) {
                    this.top_title = top_title;
                }

                public int getTop_opentype() {
                    return top_opentype;
                }

                public void setTop_opentype(int top_opentype) {
                    this.top_opentype = top_opentype;
                }

                public String getTop_opendata() {
                    return top_opendata;
                }

                public void setTop_opendata(String top_opendata) {
                    this.top_opendata = top_opendata;
                }
            }
        }
    }
}
