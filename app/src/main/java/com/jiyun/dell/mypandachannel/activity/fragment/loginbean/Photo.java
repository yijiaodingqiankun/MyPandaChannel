package com.jiyun.dell.mypandachannel.activity.fragment.loginbean;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/11/29.
 */

public class Photo {

    /**
     * timestamp : 2017-11-29 09:02:22
     * ticket : e7f395cf-2ea6-44c2-95c4-0f3998744e17
     * errType : 0
     * errMsg : 成功
     * sso : []
     * user_seq_id : 57127660
     * usrid : 571276601511749752032
     */

    private String timestamp;
    private String ticket;
    private String errType;
    private String errMsg;
    private String user_seq_id;
    private String usrid;
    private List<?> sso;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getUser_seq_id() {
        return user_seq_id;
    }

    public void setUser_seq_id(String user_seq_id) {
        this.user_seq_id = user_seq_id;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public List<?> getSso() {
        return sso;
    }

    public void setSso(List<?> sso) {
        this.sso = sso;
    }
}
