package com.jiyun.dell.mypandachannel.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jiyun.dell.mypandachannel.LiveChinaFragment.adapter.MyTabVpAdapter;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.bean.Videoss;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.fragment.LiveFragment;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.presenter.IPresenter;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.presenter.Presenter;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.view.IView;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static android.R.attr.order;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveChinaFragment extends BaseFragment implements IView {

    @Bind(R.id.lb_tab)
    TabLayout lbTab;
    @Bind(R.id.lb_vp)
    ViewPager lbVp;
    List<String> listTitle = new ArrayList<>();
    List<Fragment> list = new ArrayList<>();


    @Override
    protected void initView() {

        IPresenter iPresenter = new Presenter(this);
        iPresenter.pass();


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_china;
    }


    @Override
    public void updata(List<Videoss.TablistBean> list) {
        for (int i = 0; i < list.size(); i++) {
            String url = list.get(i).getUrl();
            String order = list.get(i).getOrder();
            String title = list.get(i).getTitle();
            listTitle.add(title);
            this.list.add(new LiveFragment(url,order));

        }
        MyTabVpAdapter adapter = new MyTabVpAdapter(getActivity().getSupportFragmentManager(), this.list,listTitle);
        lbVp.setAdapter(adapter);
        lbTab.setupWithViewPager(lbVp);
        lbVp.setCurrentItem(0);
    }
}
