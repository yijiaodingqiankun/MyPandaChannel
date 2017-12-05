package com.jiyun.dell.mypandachannel.fragment;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;
import com.jiyun.dell.mypandachannel.pandaslivefragment.adapter.MyListViewAdapter;
import com.jiyun.dell.mypandachannel.pandaslivefragment.bean.Todal;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twopresenter.ITwoPresenter;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twopresenter.TwoPresenterImp;
import com.jiyun.dell.mypandachannel.pandaslivefragment.twoview.ITwoView;

import java.util.List;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class PandasLiveFragment extends BaseFragment implements ITwoView {


    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.prt)
    PtrFrameLayout prt;


    @Override
    protected void initView() {
        ITwoPresenter iTwoPresenter = new TwoPresenterImp(this);
        iTwoPresenter.chuan();


        prt.setResistance(1.7f);
        prt.setRatioOfHeaderHeightToRefresh(1.2f);
        prt.setDurationToClose(200);
        prt.setDurationToCloseHeader(1000);
        prt.setPullToRefresh(false);
        prt.setPinContent(false);
        prt.setKeepHeaderWhenRefresh(true);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pandas_live;
    }


    @Override
    public void updata(List<Todal.ListBean> list) {


        MyListViewAdapter adapter = new MyListViewAdapter(getActivity(), list);
        listview.setAdapter(adapter);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_img, null);
        ImageView imgxm = view.findViewById(R.id.imgxm);
        TextView tv = view.findViewById(R.id.tv);
        listview.addHeaderView(view);

        Glide.with(this).load("http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/13/1497337653079_517.jpg").into(imgxm);
        tv.setText("旅日大熊猫“仙女”成功产下2017首胎海外熊猫幼仔");

        //设置下拉刷新头                   经典头视图
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getActivity());
        prt.setHeaderView(header);
        prt.addPtrUIHandler(header);


        /*prt.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

            }
        });*/
    }


}
