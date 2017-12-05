package com.jiyun.dell.mypandachannel.activity.fragment.loginbean;

/**
 * Created by DELL zhanghuirong on 2017/11/29.
 */

public class FaceandName {

    /**
     * code : 0
     * content : {"nickname":false,"userface":"http://userface.img.cctvpic.com/80x80/0/0/.jpg"}
     */

    private int code;
    private ContentBean content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * nickname : false
         * userface : http://userface.img.cctvpic.com/80x80/0/0/.jpg
         */

        private boolean nickname;
        private String userface;

        public boolean isNickname() {
            return nickname;
        }

        public void setNickname(boolean nickname) {
            this.nickname = nickname;
        }

        public String getUserface() {
            return userface;
        }

        public void setUserface(String userface) {
            this.userface = userface;
        }
    }
}
