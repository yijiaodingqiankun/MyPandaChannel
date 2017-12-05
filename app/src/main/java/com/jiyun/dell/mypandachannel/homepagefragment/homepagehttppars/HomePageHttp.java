package com.jiyun.dell.mypandachannel.homepagefragment.homepagehttppars;

import com.jiyun.dell.mypandachannel.homepagefragment.bean.Shouye;
import com.jiyun.dell.mypandachannel.homepagefragment.model.HomeCallbacks;
import com.jiyun.dell.mypandachannel.tool.retrofit2util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL zhanghuirong on 2017/11/22.
 */

public class HomePageHttp implements Callback<Shouye> {
    private final HomeCallbacks homeCallbacks;
    private List<Object> listdata = new ArrayList<>();

    public HomePageHttp(HomeCallbacks homeCallbacks) {
        this.homeCallbacks = homeCallbacks;
    }

    public void get() {
        Call<Shouye> getshouye = RetrofitUtil.getInstance().getshouye();
        getshouye.enqueue(this);
    }

    @Override
    public void onResponse(Call<Shouye> call, Response<Shouye> response) {
        Shouye.DataBean data = response.body().getData();
        //轮播图
        List<Shouye.DataBean.BigImgBean> bigImg = data.getBigImg();
        //精彩推荐
        Shouye.DataBean.AreaBean area = data.getArea();
        //熊猫观察
        Shouye.DataBean.PandaeyeBean pandaeye = data.getPandaeye();
        //熊猫直播
        Shouye.DataBean.PandaliveBean pandalive = data.getPandalive();
        //长城直播
        Shouye.DataBean.WallliveBean walllive = data.getWalllive();
        //直播中国
        Shouye.DataBean.ChinaliveBean chinalive = data.getChinalive();
        //特别策划
        Shouye.DataBean.InteractiveBean interactive = data.getInteractive();
        //CCTV
        Shouye.DataBean.CctvBean cctv = data.getCctv();
        //光影中国
        List<Shouye.DataBean.ListBeanXXX> list = data.getList();


        listdata.add(bigImg);
        listdata.add(area);
        listdata.add(pandaeye);
        listdata.add(pandalive);
        listdata.add(walllive);
        listdata.add(chinalive);
        listdata.add(interactive);
        listdata.add(cctv);
        listdata.add(list);


        homeCallbacks.goback(listdata);
    }

    @Override
    public void onFailure(Call<Shouye> call, Throwable t) {

    }
}
