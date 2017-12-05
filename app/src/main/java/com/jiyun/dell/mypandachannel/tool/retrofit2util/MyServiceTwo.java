package com.jiyun.dell.mypandachannel.tool.retrofit2util;

import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.Todal;
import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.XiongMao;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public interface MyServiceTwo {

    @GET("kehuduan/PAGE14503485387528442/index.json")
    Call<XiongMao> getTwoImg();

    @GET("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda")
    Call<Todal> getTwoTodal();
}
