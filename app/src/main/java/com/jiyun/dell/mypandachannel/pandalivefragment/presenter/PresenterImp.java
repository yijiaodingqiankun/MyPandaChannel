package com.jiyun.dell.mypandachannel.pandalivefragment.presenter;

import com.jiyun.dell.mypandachannel.pandalivefragment.bean.VideoSet;
import com.jiyun.dell.mypandachannel.pandalivefragment.model.Callbacksmo;
import com.jiyun.dell.mypandachannel.pandalivefragment.model.IModel;
import com.jiyun.dell.mypandachannel.pandalivefragment.model.Modelimp;
import com.jiyun.dell.mypandachannel.pandalivefragment.view.IView;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/2.
 */

public class PresenterImp implements IPresenter,Callbacksmo{
    private IModel iModel;
    private IView iView;

    public PresenterImp(IView iView) {
        this.iView = iView;
        iModel=new Modelimp();
    }

    @Override
    public void viewTomodel() {
        iModel.getdat(this);
    }

    @Override
    public void fanhui(List<VideoSet.VideoBean> list) {
        iView.updata(list);
    }
}
