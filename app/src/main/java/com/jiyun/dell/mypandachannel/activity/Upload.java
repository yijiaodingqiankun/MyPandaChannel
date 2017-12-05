package com.jiyun.dell.mypandachannel.activity;

import com.jiyun.dell.mypandachannel.tool.okhttputil.OkHttpUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static com.jiyun.dell.mypandachannel.activity.LoginActivity.CLIENT;

/**
 * Created by DELL zhanghuirong on 2017/11/30.
 * 上传头像
 */

public class Upload {
    private static Upload upload;
    private OkHttpClient okHttpClient;
    private String JSESSIONID;
    private String verifycode;
    private String uct;


    private Upload() {
        okHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
            List<Cookie> cookies = new ArrayList<Cookie>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                this.cookies = cookies;

                for (Cookie cookie : cookies) {
                    if ("JSESSIONID".equals(cookie.name())) {
                        JSESSIONID = cookie.value();
                    } else if ("verifycode".equals(cookie.name())) {
                        verifycode = cookie.value();
                        Shar.getInstance().setEdit("verifycode", verifycode);
                    } else if ("uct".equals(cookie.name())) {
                        uct = cookie.value();
                    }
                }
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return cookies;
            }
        }).build();
    }

    public static Upload getInstance() {
        if (upload == null) {
            synchronized (OkHttpUtil.class) {
                if (upload == null) {
                    upload = new Upload();
                }
            }
        }
        return upload;
    }

    /**
     * 上传头像
     *
     * @param url
     * @param callback
     * @param userId
     * @param file
     */
    public void postFace(String url, Callback callback, String userId, File file) {
        RequestBody body = new FormBody.Builder()
                .add("client", CLIENT)
                .add("method", "user.alterUserFace")
                .add("userid", userId)
                .add("facefile", String.valueOf(file))
                .build();
        Request request = new Request.Builder().url(url).method("POST", body).build();

        okHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 修改昵称
     *
     * @param url
     * @param callback
     * @param userId
     */
    public void postNickName(String url, Callback callback, String userId, String nickName) {
        RequestBody body = new FormBody.Builder()
                .add("client", CLIENT)
                .add("method", "user.alterNickName")
                .add("userid", userId)
                .add("nickname", nickName)
                .build();
        Request request = new Request.Builder().url(url).method("POST", body).build();

        okHttpClient.newCall(request).enqueue(callback);
    }
}
