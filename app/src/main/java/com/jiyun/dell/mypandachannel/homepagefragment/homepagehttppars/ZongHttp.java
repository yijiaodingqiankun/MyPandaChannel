package com.jiyun.dell.mypandachannel.homepagefragment.homepagehttppars;

import com.jiyun.dell.mypandachannel.homepagefragment.bean.Zong;
import com.jiyun.dell.mypandachannel.homepagefragment.model.HomeCallbacks;
import com.jiyun.dell.mypandachannel.tool.retrofit2util.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL zhanghuirong on 2017/11/22.
 */

public class ZongHttp implements Callback<Zong> {
    private final HomeCallbacks homeCallbacks;

    public ZongHttp(HomeCallbacks homeCallbacks) {
        this.homeCallbacks = homeCallbacks;
    }

    public void get() {
        Call<Zong> getbiaoqian = RetrofitUtil.getInstance().getbiaoqian();
        getbiaoqian.enqueue(this);
    }

    @Override
    public void onResponse(Call<Zong> call, Response<Zong> response) {
        List<Zong.TabBean> tab = response.body().getTab();
        homeCallbacks.goback(tab);
    }

    @Override
    public void onFailure(Call<Zong> call, Throwable t) {

    }
}
