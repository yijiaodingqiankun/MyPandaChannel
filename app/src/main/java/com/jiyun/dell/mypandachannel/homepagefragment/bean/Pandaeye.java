package com.jiyun.dell.mypandachannel.homepagefragment.bean;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/11/22.
 */

public class Pandaeye {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * url : http://panview.ipanda.com/2017/06/14/VIDE9KtPTNDzejj693BpDdWJ170614.shtml
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/14/1497403375650_254.jpg
         * title : 英国一年一度抬床赛 比赛过程欢乐多
         * videoLength : 01:01
         * id : TITE1497403381691376
         * daytime : 2017-06-14
         * type : 2
         * pid : 942717445a0446eb90513607b0a2122d
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String videoLength;
        private String id;
        private String daytime;
        private String type;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
