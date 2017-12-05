package com.jiyun.dell.mypandachannel.tool.retrofit2util;

import com.jiyun.dell.mypandachannel.homepagefragment.bean.Cctv;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.GuanYing;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Pandaeye;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Shouye;
import com.jiyun.dell.mypandachannel.homepagefragment.bean.Zong;
import com.jiyun.dell.mypandachannel.pandalivefragment.PandaLive;
import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.Todal;
import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.XiongMao;
import com.jiyun.dell.mypandachannel.urls.Urls;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL zhanghuirong on 2017/11/21.
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;
    private Retrofit retrofit;

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }



    //总url
    public Call<Zong> getbiaoqian() {
        //获取接口类对象
        MyService myService = retrofit.create(MyService.class);
        //用接口类对象调用里面的方法
        Call<Zong> getbiaoqian = myService.getbiaoqian();

        return getbiaoqian;


    }

    //首页url
    public Call<Shouye> getshouye() {
        MyService myService = retrofit.create(MyService.class);
        Call<Shouye> getshouye = myService.getshouye();
        return getshouye;
    }

    public Call<Pandaeye> getpanda() {
        MyService myService = retrofit.create(MyService.class);
        Call<Pandaeye> pandaeye = myService.getPandaeye();
        return pandaeye;
    }

    public Call<GuanYing> getGuanying() {
        MyService myService = retrofit.create(MyService.class);
        Call<GuanYing> guanying = myService.getGuanying();
        return guanying;
    }

    public Call<Cctv> getCctv() {
        MyService myService = retrofit.create(MyService.class);
        Call<Cctv> cctv = myService.getCctv();
        return cctv;
    }


    public Call<XiongMao> getTwoXiongMao() {
        MyServiceTwo myServiceTwo = retrofit.create(MyServiceTwo.class);
        Call<XiongMao> twoImg = myServiceTwo.getTwoImg();
        return twoImg;
    }

    public Call<Todal> getTwoTodals() {
        MyServiceTwo myServiceTwo = retrofit.create(MyServiceTwo.class);
        Call<Todal> twoTodal = myServiceTwo.getTwoTodal();
        return twoTodal;
    }

    public Call<PandaLive> getFourdata(){
        MyServiceFour myServiceFour = retrofit.create(MyServiceFour.class);
        Call<PandaLive> getdata = myServiceFour.getdata();

        return getdata;


    }
}
