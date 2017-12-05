package com.jiyun.dell.mypandachannel;

import com.jiyun.dell.mypandachannel.tool.okhttputil.OkHttpUtil;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class HttpFactory {
    public static OkHttpUtil create(){
        return OkHttpUtil.getInstance();
    }
}
