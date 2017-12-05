package com.jiyun.dell.mypandachannel.activity;

import android.content.SharedPreferences;

import com.jiyun.dell.mypandachannel.crach.App;
import com.jiyun.dell.mypandachannel.tool.okhttputil.OkHttpUtil;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by DELL zhanghuirong on 2017/11/30.
 */

public class Shar {
    private static Shar shar;
    private SharedPreferences user;

    private Shar() {
        user = App.activity.getSharedPreferences("user", MODE_PRIVATE);
    }

    public static Shar getInstance() {
        if (shar == null) {
            synchronized (OkHttpUtil.class) {
                if (shar == null) {
                    shar = new Shar();
                }
            }
        }
        return shar;
    }

    public void setEdit(String key, String valuer) {
        user.edit().putString(key, valuer).commit();
    }

    public String getEdit(String key, String valuer) {
        String string = user.getString(key, valuer);
        return string;
    }

    public void remove() {
        user.edit().clear().commit();
    }
}
