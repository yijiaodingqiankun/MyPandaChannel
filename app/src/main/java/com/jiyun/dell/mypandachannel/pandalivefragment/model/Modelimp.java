package com.jiyun.dell.mypandachannel.pandalivefragment.model;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.HttpFactory;
import com.jiyun.dell.mypandachannel.pandalivefragment.bean.VideoSet;
import com.jiyun.dell.mypandachannel.tool.okhttputil.NetWorkCallback;
import com.jiyun.dell.mypandachannel.urls.Urls;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/2.
 */

public class Modelimp implements IModel {
    @Override
    public void getdat(final Callbacksmo callbacksmo) {
        HttpFactory.create().get(Urls.Wonderful, null, new NetWorkCallback() {
            @Override
            public void onSuccess(String string) {
                Gson gson=new Gson();
                VideoSet videoSet = gson.fromJson(string, VideoSet.class);
                List<VideoSet.VideoBean> video = videoSet.getVideo();
                callbacksmo.fanhui(video);
            }

            @Override
            public void onError(String e) {

            }
        });
    }
}
