package com.jiyun.dell.mypandachannel.pandalivefragment.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/2.
 */

public class VideoSet {


    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"5572"}
     * video : [{"vsid":"VSET100167216881","order":"5584","vid":"d8487f993de34d3dbc741555a880f752","t":"《精彩一刻》 20171202 \u201c乔伊\u201d：奶妈，你咋走了呀~","url":"http://tv.cntv.cn/video/VSET100167216881/d8487f993de34d3dbc741555a880f752","ptime":"2017-12-02 10:03:23","img":"http://p5.img.cctvpic.com/fmspic/2017/12/02/d8487f993de34d3dbc741555a880f752-20.jpg?p=2&h=120","len":"00:00:20","em":"CM01"},{"vsid":"VSET100167216881","order":"5583","vid":"4ea4d886dd6e4a15811f44738b32fae9","t":"《精彩一刻》 20171202 再凶也得乖乖跟我回家","url":"http://tv.cntv.cn/video/VSET100167216881/4ea4d886dd6e4a15811f44738b32fae9","ptime":"2017-12-02 10:01:50","img":"http://p4.img.cctvpic.com/fmspic/2017/12/02/4ea4d886dd6e4a15811f44738b32fae9-24.jpg?p=2&h=120","len":"00:00:29","em":"CM01"},{"vsid":"VSET100167216881","order":"5581","vid":"992d026146f34e38a057e870d2493f63","t":"《精彩一刻》 20171202 \u201c森森\u201d：用来睡觉刚刚好~","url":"http://tv.cntv.cn/video/VSET100167216881/992d026146f34e38a057e870d2493f63","ptime":"2017-12-02 09:59:36","img":"http://p2.img.cctvpic.com/fmspic/2017/12/02/992d026146f34e38a057e870d2493f63-32.jpg?p=2&h=120","len":"00:00:43","em":"CM01"},{"vsid":"VSET100167216881","order":"5582","vid":"662fad16b721422392ee0aee664cd160","t":"《精彩一刻》 20171202 有只地鼠混进了熊猫圈","url":"http://tv.cntv.cn/video/VSET100167216881/662fad16b721422392ee0aee664cd160","ptime":"2017-12-02 09:58:28","img":"http://p4.img.cctvpic.com/fmspic/2017/12/02/662fad16b721422392ee0aee664cd160-35.jpg?p=2&h=120","len":"00:00:50","em":"CM01"},{"vsid":"VSET100167216881","order":"5580","vid":"3c1ad731ac994e3baf617805873ea19a","t":"《精彩一刻》 20171202 吃饱了也要锻炼一下~","url":"http://tv.cntv.cn/video/VSET100167216881/3c1ad731ac994e3baf617805873ea19a","ptime":"2017-12-02 09:57:18","img":"http://p1.img.cctvpic.com/fmspic/2017/12/02/3c1ad731ac994e3baf617805873ea19a-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"5585","vid":"57fb5b8377c74f75bd1321ae52ff7a24","t":"《精彩一刻》 20171202 让我看看里面有啥","url":"http://tv.cntv.cn/video/VSET100167216881/57fb5b8377c74f75bd1321ae52ff7a24","ptime":"2017-12-02 09:55:32","img":"http://p1.img.cctvpic.com/fmspic/2017/12/02/57fb5b8377c74f75bd1321ae52ff7a24-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"5586","vid":"50b0d85efe3e4fd1ad2cce589ea48924","t":"《精彩一刻》 20171202 树枝？胡说！这是小仙棒~","url":"http://tv.cntv.cn/video/VSET100167216881/50b0d85efe3e4fd1ad2cce589ea48924","ptime":"2017-12-02 09:53:46","img":"http://p3.img.cctvpic.com/fmspic/2017/12/02/50b0d85efe3e4fd1ad2cce589ea48924-9.jpg?p=2&h=120","len":"00:00:18","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 5572
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 5584
         * vid : d8487f993de34d3dbc741555a880f752
         * t : 《精彩一刻》 20171202 “乔伊”：奶妈，你咋走了呀~
         * url : http://tv.cntv.cn/video/VSET100167216881/d8487f993de34d3dbc741555a880f752
         * ptime : 2017-12-02 10:03:23
         * img : http://p5.img.cctvpic.com/fmspic/2017/12/02/d8487f993de34d3dbc741555a880f752-20.jpg?p=2&h=120
         * len : 00:00:20
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
