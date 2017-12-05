package com.jiyun.dell.mypandachannel.tool.retrofit2util;

import com.jiyun.dell.mypandachannel.pandalivefragment.PandaLive;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL zhanghuirong on 2017/12/1.
 */

public interface MyServiceFour {

    @GET("kehuduan/PAGE14501775094142282/index.json")
    Call<PandaLive> getdata();
}
