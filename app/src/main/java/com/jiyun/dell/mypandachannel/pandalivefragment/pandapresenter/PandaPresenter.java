package com.jiyun.dell.mypandachannel.pandalivefragment.pandapresenter;

import com.jiyun.dell.mypandachannel.pandalivefragment.PandaLive;
import com.jiyun.dell.mypandachannel.pandalivefragment.pandalivemodel.IPandaLiveModel;
import com.jiyun.dell.mypandachannel.pandalivefragment.pandalivemodel.PanCallback;
import com.jiyun.dell.mypandachannel.pandalivefragment.pandalivemodel.PandaModelimp;
import com.jiyun.dell.mypandachannel.pandalivefragment.pandaliveview.IPandaLiveView;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/12/1.
 */

public class PandaPresenter implements IPandaPresenter, PanCallback {
    IPandaLiveModel iPandaLiveModel;
    IPandaLiveView iPandaLiveView;

    public PandaPresenter(IPandaLiveView iPandaLiveView) {
        this.iPandaLiveView = iPandaLiveView;
        iPandaLiveModel = new PandaModelimp();
    }

    @Override
    public void chuancan() {
        iPandaLiveModel.getdata(this);
    }

    @Override
    public void fanhui(List<PandaLive.TablistBean> list) {
        iPandaLiveView.updata(list);
    }
}
