package com.jiyun.dell.mypandachannel.mainmodel;

import android.support.v4.app.Fragment;

import com.jiyun.dell.mypandachannel.fragment.HomePageFragment;
import com.jiyun.dell.mypandachannel.fragment.LiveChinaFragment;
import com.jiyun.dell.mypandachannel.fragment.PandasBroadcastFragment;
import com.jiyun.dell.mypandachannel.fragment.PandasLiveFragment;
import com.jiyun.dell.mypandachannel.fragment.RollingVideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/11/19.
 */

public class MainModel implements MainModelInf {

    @Override
    public void getMainData(Callbacks callbacks) {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomePageFragment());//首页
        list.add(new PandasLiveFragment());//熊猫观察
        list.add(new RollingVideoFragment());//熊猫文化
        list.add(new PandasBroadcastFragment());//熊猫直播
        list.add(new LiveChinaFragment());//直播中国
        callbacks.getData(list);
    }
}
