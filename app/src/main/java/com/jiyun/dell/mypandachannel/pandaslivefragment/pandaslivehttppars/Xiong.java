package com.jiyun.dell.mypandachannel.pandaslivefragment.pandaslivehttppars;

import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.Todal;
import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.XiongMao;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twomodel.TwoCallbacks;
import com.jiyun.dell.mypandachannel.tool.retrofit2util.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class Xiong implements Callback<XiongMao> {
    private final TwoCallbacks twoCallbacks;

    public Xiong(TwoCallbacks twoCallbacks) {
        this.twoCallbacks = twoCallbacks;
    }

    public void getXiong() {
        Call<XiongMao> twoXiongMao = RetrofitUtil.getInstance().getTwoXiongMao();
        twoXiongMao.enqueue(this);
    }

    @Override
    public void onResponse(Call<XiongMao> call, Response<XiongMao> response) {
        XiongMao.DataBean data = response.body().getData();
        List<XiongMao.DataBean.BigImgBean> bigImg = data.getBigImg();
        twoCallbacks.getData(bigImg);
    }

    @Override
    public void onFailure(Call<XiongMao> call, Throwable t) {

    }


    public void getTodal(){
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
