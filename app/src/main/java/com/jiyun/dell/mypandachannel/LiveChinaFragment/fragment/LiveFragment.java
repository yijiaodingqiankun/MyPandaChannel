package com.jiyun.dell.mypandachannel.LiveChinaFragment.fragment;


import android.widget.ListView;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.HttpFactory;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.bean.Live;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;
import com.jiyun.dell.mypandachannel.tool.okhttputil.NetWorkCallback;

import java.util.List;

import butterknife.Bind;

/**
 *
 */
public class LiveFragment extends BaseFragment {


    private final String url;
    private final String order;
    @Bind(R.id.listview_live)
    ListView listviewLive;
    private List<Live.LiveBean> live1;

    public LiveFragment(String url, String order) {
        this.url=url;
        this.order=order;

    }

    @Override
    protected void initView() {
        HttpFactory.create().get(url, null, new NetWorkCallback() {



            @Override
            public void onSuccess(String string) {
                Gson gson=new Gson();
                Live live = gson.fromJson(string, Live.class);
                live1 = live.getLive();
                MyListViewLiveAdapter adapter=new MyListViewLiveAdapter(getActivity(),live1);
                listviewLive.setAdapter(adapter);
            }

            @Override
            public void onError(String e) {

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

}
