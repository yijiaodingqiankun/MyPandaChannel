package com.jiyun.dell.mypandachannel.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;
import com.jiyun.dell.mypandachannel.pandalivefragment.PandaLive;
import com.jiyun.dell.mypandachannel.pandalivefragment.adapter.MyFragAdapter;
import com.jiyun.dell.mypandachannel.pandalivefragment.fragment.PandaFragment;
import com.jiyun.dell.mypandachannel.pandalivefragment.pandaliveview.IPandaLiveView;
import com.jiyun.dell.mypandachannel.pandalivefragment.pandapresenter.IPandaPresenter;
import com.jiyun.dell.mypandachannel.pandalivefragment.pandapresenter.PandaPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandasBroadcastFragment extends BaseFragment implements IPandaLiveView {


    List<String> listTitle = new ArrayList<>();
    List<Fragment> list1 = new ArrayList<>();
    @Bind(R.id.pb_tab)
    TabLayout pbTab;
    @Bind(R.id.pb_vp)
    ViewPager pbVp;

    @Override
    protected void initView() {
        IPandaPresenter iPandaPresenter = new PandaPresenter(this);
        iPandaPresenter.chuancan();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pandas_broadcast;
    }

    @Override
    public void updata(List<PandaLive.TablistBean> list) {
        for (int i = 0; i < list.size(); i++) {
            PandaLive.TablistBean tablistBean = list.get(i);
            String title = tablistBean.getTitle();
            listTitle.add(title);
            this.list1.add(new PandaFragment());
        }

        MyFragAdapter adapter = new MyFragAdapter(getActivity().getSupportFragmentManager(), list1, listTitle);
        pbVp.setAdapter(adapter);
        pbTab.setupWithViewPager(pbVp);
        pbVp.setCurrentItem(0);

    }

}
