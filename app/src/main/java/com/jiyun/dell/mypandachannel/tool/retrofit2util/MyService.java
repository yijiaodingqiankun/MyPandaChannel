package com.jiyun.dell.mypandachannel.tool.retrofit2util;

import com.jiyun.dell.mypandachannel.homepagefragment.bean.Cctv;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.GuanYing;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Pandaeye;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Shouye;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Zong;
import com.jiyun.dell.mypandachannel.homepagefragment.homepagehttppars.CctvPars;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL zhanghuirong on 2017/11/21.
 */

public interface MyService {
    //总url
    @GET("kehuduan/PAGE1450172284887217/index.json")
    Call<Zong> getbiaoqian();

    //首页url
    @GET("kehuduan/PAGE14501749764071042/index.json")
    Call<Shouye> getshouye();

    //熊猫观察的url
//    http://www.ipanda.com/kehuduan/shipinliebieye/xiongmaoguancha/index.json
    @GET("kehuduan/shipinliebieye/xiongmaoguancha/index.json")
    Call<Pandaeye> getPandaeye();

//CCTV
//    http://www.ipanda.com/kehuduan/shipinliebieye/cctvshipindicengye/index.json
    @GET("kehuduan/shipinliebieye/cctvshipindicengye/index.json")
    Call<Cctv> getCctv();


//光影中国
//    http://www.ipanda.com/kehuduan/shipinliebieye/guangyingzhongguo/index.json
    @GET("kehuduan/shipinliebieye/guangyingzhongguo/index.json")
    Call<GuanYing> getGuanying();
}
