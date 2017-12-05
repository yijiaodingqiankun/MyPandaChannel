package com.jiyun.dell.mypandachannel.homepagefragment.presenter;

import com.jiyun.dell.mypandachannel.homepagefragment.model.HomeCallbacks;
import com.jiyun.dell.mypandachannel.homepagefragment.model.IModel;
import com.jiyun.dell.mypandachannel.homepagefragment.model.ModelImp;
import com.jiyun.dell.mypandachannel.homepagefragment.view.IView;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/11/21.
 */

public class Presenterimp implements IPresenter, HomeCallbacks {
    private IModel model;
    private IView view;

    public Presenterimp(IView view) {
        this.view = view;
        model = new ModelImp();
    }

    @Override
    public void iviewToimodel() {
        model.homepage(this);
    }


    @Override
    public <T> void goback(List<T> list) {
        view.updata((List<Object>) list);
    }
}
