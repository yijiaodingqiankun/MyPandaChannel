package com.jiyun.dell.mypandachannel.tool.okhttputil;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class OkHttp3Util {
    private static OkHttp3Util okHttpUtil;
    private OkHttpClient okHttpClient;

    private OkHttp3Util() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public static OkHttp3Util getInstance() {
        if (okHttpUtil == null) {
            synchronized (OkHttp3Util.class) {
                if (okHttpUtil == null) {
                    okHttpUtil = new OkHttp3Util();
                }
            }
        }
        return okHttpUtil;
    }

    public void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public void post(String url, String username, String password, Callback callback) {
        RequestBody body = new FormBody.Builder().add("Referer",url).add("User-Agent","CNTV_APP_CLIENT_CYNTV_MOBILE").add("username", username).add("password", password).build();
        Request request = new Request.Builder().url(url).method("POST", body).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
