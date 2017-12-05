package com.jiyun.dell.mypandachannel.pandaslivefragment.twomodel;

import com.jiyun.dell.mypandachannel.pandaslivefragment.pandaslivehttppars.Xiong;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class TwoModelImp implements ITwoModel{

    @Override
    public void getData(TwoCallbacks twoCallbacks) {
        Xiong xiong = new Xiong(twoCallbacks);
//        xiong.getXiong();
        xiong.getTodal();

    }
}
