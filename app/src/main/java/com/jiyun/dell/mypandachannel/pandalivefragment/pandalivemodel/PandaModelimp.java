package com.jiyun.dell.mypandachannel.pandalivefragment.pandalivemodel;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.HttpFactory;
import com.jiyun.dell.mypandachannel.pandalivefragment.PandaLive;
import com.jiyun.dell.mypandachannel.tool.okhttputil.NetWorkCallback;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/1.
 */

public class PandaModelimp implements IPandaLiveModel {
    @Override
    public void getdata(final PanCallback callback) {
        HttpFactory.create().get("http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json", null, new NetWorkCallback() {
            @Override
            public void onSuccess(String string) {
                Gson gson=new Gson();
                PandaLive pandaLive = gson.fromJson(string, PandaLive.class);
                List<PandaLive.TablistBean> tablist = pandaLive.getTablist();
                callback.fanhui(tablist);
            }

            @Override
            public void onError(String e) {

            }
        });
    }
}
