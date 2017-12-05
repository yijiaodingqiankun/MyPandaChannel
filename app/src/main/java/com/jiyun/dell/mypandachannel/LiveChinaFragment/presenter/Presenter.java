package com.jiyun.dell.mypandachannel.LiveChinaFragment.presenter;

import com.jiyun.dell.mypandachannel.LiveChinaFragment.bean.Videoss;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.model.CallbackFragment;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.model.IliveModel;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.model.Model;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.view.IView;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/3.
 */

public class Presenter implements IPresenter, CallbackFragment {
    IliveModel iliveModel;
    IView iView;

    public Presenter(IView iView) {
        this.iView = iView;
        iliveModel = new Model();
    }

    @Override
    public void pass() {
        iliveModel.getdata(this);
    }

    @Override
    public void fanhui(List<Videoss.TablistBean> list) {
        iView.updata(list);
    }
}
