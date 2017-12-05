package com.jiyun.dell.mypandachannel.activity;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DELL zhanghuirong on 2017/11/30.
 */

public class ToastUtils {
    public static void showShort(Context context, String string) {
        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }
}
