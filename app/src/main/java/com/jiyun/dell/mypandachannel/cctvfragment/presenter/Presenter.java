package com.jiyun.dell.mypandachannel.cctvfragment.presenter;


import com.jiyun.dell.mypandachannel.cctvfragment.bean.Game;
import com.jiyun.dell.mypandachannel.cctvfragment.model.Callbackcctv;
import com.jiyun.dell.mypandachannel.cctvfragment.model.IModel;
import com.jiyun.dell.mypandachannel.cctvfragment.model.Modelcctv;
import com.jiyun.dell.mypandachannel.cctvfragment.view.IView;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/4.
 */

public class Presenter implements IPresenter,Callbackcctv {

    private IModel iModel;
    private IView iView;

    public Presenter(IView iView) {
        this.iView = iView;
        iModel = new Modelcctv();
    }

    @Override
    public void viewTomodel() {
        iModel.getdata(this);
    }

    @Override
    public void back(List<Game.ListBean> list) {
        iView.updata(list);
    }
}
