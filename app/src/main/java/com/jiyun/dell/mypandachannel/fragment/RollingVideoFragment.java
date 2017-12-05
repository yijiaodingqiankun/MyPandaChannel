package com.jiyun.dell.mypandachannel.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;
import com.jiyun.dell.mypandachannel.cctvfragment.adapter.MyListViewAdapter;
import com.jiyun.dell.mypandachannel.cctvfragment.bean.Game;
import com.jiyun.dell.mypandachannel.cctvfragment.presenter.IPresenter;
import com.jiyun.dell.mypandachannel.cctvfragment.presenter.Presenter;
import com.jiyun.dell.mypandachannel.cctvfragment.view.IView;
import com.jiyun.dell.mypandachannel.homepagefragment.GlideImageLoder;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class RollingVideoFragment extends BaseFragment implements IView {


    Banner rvBanner;
    @Bind(R.id.rv_listview)
    ListView rvListview;


    @Override
    protected void initView() {


        IPresenter iPresenter = new Presenter(this);
        iPresenter.viewTomodel();

       /* ptr.setResistance(1.7f);
        ptr.setRatioOfHeaderHeightToRefresh(1.2f);
        ptr.setDurationToClose(200);
        ptr.setDurationToCloseHeader(1000);
// default is false
        ptr.setPullToRefresh(false);
// default is true
        ptr.setKeepHeaderWhenRefresh(true);

        //设置下拉刷新头
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getActivity());
        ptr.setHeaderView(header);
        ptr.addPtrUIHandler(header);*/

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rolling_video;
    }

    @Override
    public void updata(List<Game.ListBean> list) {
        MyListViewAdapter adapter = new MyListViewAdapter(getActivity(), list);
        rvListview.setAdapter(adapter);

        View view = View.inflate(getActivity(), R.layout.item_cctv_head, null);
        rvBanner = view.findViewById(R.id.rv_banner);
        rvListview.addHeaderView(view);

        List<String> list1 = new ArrayList<>();
        list1.add("http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/16/1497597712866_826.jpg");
        list1.add("http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/16/1497597712866_826.jpg");
        rvBanner.setImageLoader(new GlideImageLoder());
        rvBanner.setImages(list1);
        rvBanner.start();
    }


}
