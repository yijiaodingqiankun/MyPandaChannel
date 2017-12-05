package com.jiyun.dell.mypandachannel.tool.okhttputil;

import com.jiyun.dell.mypandachannel.crach.App;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by DELL zhanghuirong on 2017/11/20.
 */

public class OkHttpUtil {
    private static OkHttpUtil okHttpUtil;
    private OkHttpClient okHttpClient;

    private OkHttpUtil() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public static OkHttpUtil getInstance() {
        if (okHttpUtil == null) {
            synchronized (OkHttpUtil.class) {
                if (okHttpUtil == null) {
                    okHttpUtil = new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }

    public void get(String url, Map<String, String> map, final NetWorkCallback netWorkCallback) {
        if (map != null && map.size() > 1) {
            StringBuffer sb = new StringBuffer(url);
            sb.append("?");
            //得到key
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                sb.append(key).append("=").append(map.get(key)).append("&");
            }
            url = sb.substring(0, sb.length() - 1);
        }
        final Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netWorkCallback.onError( e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Gson gson = new Gson();
//                        Type[] types = netWorkCallback.getClass().getGenericInterfaces();
//                        Type[] typeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
//                        Type typeArgument = typeArguments[0];
//                        T o = gson.fromJson(string, typeArgument);

                        netWorkCallback.onSuccess(string);
                    }
                });

            }
        });
    }

    public void post(String url, Callback callback) {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder().url(url).method("POST", body).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
