package com.jiyun.dell.mypandachannel.pandaslivefragment.twopresenter;

import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.Todal;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twomodel.ITwoModel;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twomodel.TwoCallbacks;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twomodel.TwoModelImp;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twoview.ITwoView;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public class TwoPresenterImp implements ITwoPresenter, TwoCallbacks {
    private ITwoModel iTwoModel;
    private ITwoView iTwoView;

    public TwoPresenterImp(ITwoView iTwoView) {
        this.iTwoView = iTwoView;
        iTwoModel = new TwoModelImp();
    }


    @Override
    public void chuan() {
        iTwoModel.getData(this);
    }

    @Override
    public <T> void getData(List<T> list) {
        iTwoView.updata((List<Todal.ListBean>) list);
    }
}
