package com.jiyun.dell.mypandachannel.LiveChinaFragment.model;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.HttpFactory;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.bean.Videoss;
import com.jiyun.dell.mypandachannel.tool.okhttputil.NetWorkCallback;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/3.
 */

public class Model implements IliveModel {
    @Override
    public void getdata(final CallbackFragment callbackFragment) {
        HttpFactory.create().get("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json", null, new NetWorkCallback() {
            @Override
            public void onSuccess(String string) {
                Gson gson=new Gson();
                Videoss videoss = gson.fromJson(string, Videoss.class);
                List<Videoss.TablistBean> tablist = videoss.getTablist();
                callbackFragment.fanhui(tablist);
            }

            @Override
            public void onError(String e) {

            }
        });
    }
}
