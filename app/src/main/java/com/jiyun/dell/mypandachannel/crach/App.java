package com.jiyun.dell.mypandachannel.crach;

import android.app.Application;

import com.jiyun.dell.mypandachannel.base.BaseActivity;

/**
 * Created by DELL zhanghuirong on 2017/11/21.
 */

public class App extends Application {
    public static  BaseActivity activity ;
    @Override
    public void onCreate() {
        super.onCreate();
        //启动异常捕获类的
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());

    }
}
