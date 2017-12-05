package com.jiyun.dell.mypandachannel.cctvfragment.model;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.HttpFactory;
import com.jiyun.dell.mypandachannel.cctvfragment.bean.Game;
import com.jiyun.dell.mypandachannel.tool.okhttputil.NetWorkCallback;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/4.
 */

public class Modelcctv implements IModel {
    @Override
    public void getdata(final Callbackcctv callbackcctv) {
        HttpFactory.create().get("http://www.ipanda.com/kehuduan/PAGE14501778924722682/index.json", null, new NetWorkCallback() {
            @Override
            public void onSuccess(String string) {
                Gson gson = new Gson();
                Game game = gson.fromJson(string, Game.class);
                List<Game.ListBean> list = game.getList();
                callbackcctv.back(list);
            }

            @Override
            public void onError(String e) {

            }
        });
    }
}
