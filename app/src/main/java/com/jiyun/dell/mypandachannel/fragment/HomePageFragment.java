package com.jiyun.dell.mypandachannel.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;
import com.jiyun.dell.mypandachannel.homepagefragment.adapter.MyAdapter;
import com.jiyun.dell.mypandachannel.homepagefragment.presenter.IPresenter;
import com.jiyun.dell.mypandachannel.homepagefragment.presenter.Presenterimp;
import com.jiyun.dell.mypandachannel.homepagefragment.view.IView;

import java.util.List;

import butterknife.Bind;


public class HomePageFragment extends BaseFragment implements IView {


    @Bind(R.id.recycler)
    RecyclerView recycler;

    @Override
    protected void initView() {
        IPresenter iPresenter=new Presenterimp(this);
        iPresenter.iviewToimodel();
        Log.e("TAG","------------始开装载当前Fragment---加载数据开始------------------");
    }

    @Override
    protected int getLayoutId() {
        Log.e("TAG","------------始开装载当前Fragment------------------");
        return R.layout.fragment_home_page;
    }


    @Override
    public void updata(List<Object> list) {

        Log.e("TAG","------------开始-------0-----------");
        Log.e("TAG","获取到的数量="+list.size());
        Log.e("TAG","获取到的内容="+list.toString());
        Log.e("TAG","------------结束-------0-----------");
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        MyAdapter adapter = new MyAdapter(getActivity(),list);
        recycler.setAdapter(adapter);
    }
}
