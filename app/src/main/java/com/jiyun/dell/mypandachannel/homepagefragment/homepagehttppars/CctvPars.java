package com.jiyun.dell.mypandachannel.homepagefragment.homepagehttppars;

import com.jiyun.dell.mypandachannel.homepagefragment.bean.Cctv;
import com.jiyun.dell.mypandachannel.tool.retrofit2util.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class CctvPars {
    public void getCctv() {
        Call<Cctv> cctv = RetrofitUtil.getInstance().getCctv();
        cctv.enqueue(new Callback<Cctv>() {
            @Override
            public void onResponse(Call<Cctv> call, Response<Cctv> response) {
                List<Cctv.ListBean> list = response.body().getList();
            }

            @Override
            public void onFailure(Call<Cctv> call, Throwable t) {

            }
        });
    }
}
