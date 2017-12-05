package com.jiyun.dell.mypandachannel.pandalivefragment.fragment;


import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;
import com.jiyun.dell.mypandachannel.pandalivefragment.adapter.MyListViewAdapter;
import com.jiyun.dell.mypandachannel.pandalivefragment.bean.VideoSet;
import com.jiyun.dell.mypandachannel.pandalivefragment.presenter.IPresenter;
import com.jiyun.dell.mypandachannel.pandalivefragment.presenter.PresenterImp;
import com.jiyun.dell.mypandachannel.pandalivefragment.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandaFragment extends BaseFragment implements IView {


    @Bind(R.id.listviews)
    ListView listviews;

    @Override
    protected void initView() {
        IPresenter presenterImp = new PresenterImp(this);
        presenterImp.viewTomodel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda;
    }

    @Override
    public void updata(List<VideoSet.VideoBean> list) {
        List<VideoSet.VideoBean>  listdata=new ArrayList<>();
        listdata.addAll(list);
        MyListViewAdapter adapter = new MyListViewAdapter(getActivity(), listdata);
        listviews.setAdapter(adapter);
    }
}
