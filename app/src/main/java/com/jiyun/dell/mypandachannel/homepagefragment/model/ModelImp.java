package com.jiyun.dell.mypandachannel.homepagefragment.model;

import com.jiyun.dell.mypandachannel.homepagefragment.homepagehttppars.HomePageHttp;
import com.jiyun.dell.mypandachannel.homepagefragment.homepagehttppars.ZongHttp;

/**
 * Created by DELL zhanghuirong on 2017/11/21.
 */

public class ModelImp implements IModel {
    @Override
    public void biaoqian( HomeCallbacks homeCallbacks) {
        //解析总url
        ZongHttp zongHttp=new ZongHttp(homeCallbacks);
        zongHttp.get();
    }

    @Override
    public void homepage(HomeCallbacks homeCallbacks) {
        //解析首页的Fragment
       new HomePageHttp(homeCallbacks).get();

    }
}
