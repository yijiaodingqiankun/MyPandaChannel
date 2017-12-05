package com.jiyun.dell.mypandachannel.pandaslivefragment.pandaslivehttppars;

import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.Todal;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twomodel.TwoCallbacks;
import com.jiyun.dell.mypandachannel.tool.retrofit2util.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class TwoTodal {
    private final TwoCallbacks twoCallbacks;

    public TwoTodal(TwoCallbacks twoCallbacks) {
        this.twoCallbacks=twoCallbacks;
    }

    public void get(){
        Call<Todal> twoTodals = RetrofitUtil.getInstance().getTwoTodals();
        twoTodals.enqueue(new Callback<Todal>() {
            @Override
            public void onResponse(Call<Todal> call, Response<Todal> response) {
                List<Todal.ListBean> list = response.body().getList();
                twoCallbacks.getData(list);
            }

            @Override
            public void onFailure(Call<Todal> call, Throwable t) {

            }
        });
    }
}
