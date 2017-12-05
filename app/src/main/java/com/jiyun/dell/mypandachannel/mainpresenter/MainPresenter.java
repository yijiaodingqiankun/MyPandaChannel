package com.jiyun.dell.mypandachannel.mainpresenter;

import android.support.v4.app.Fragment;

import com.jiyun.dell.mypandachannel.mainmodel.Callbacks;
import com.jiyun.dell.mypandachannel.mainmodel.MainModel;
import com.jiyun.dell.mypandachannel.mainmodel.MainModelInf;
import com.jiyun.dell.mypandachannel.mainview.MainViewInf;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/11/19.
 */

public class MainPresenter implements MainPresenterInf ,Callbacks {
    private MainModelInf mainModelInf;
    private MainViewInf mainViewInf;

    public MainPresenter(MainViewInf mainViewInf) {
        this.mainViewInf = mainViewInf;
        mainModelInf = new MainModel();
    }

    @Override
    public void mainViewTomainModel() {
        mainModelInf.getMainData(this);
    }

    @Override
    public void getData(List<Fragment> list) {
        mainViewInf.upData(list);
    }
}
