package com.jiyun.dell.mypandachannel.activity;

import android.widget.ListView;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.HttpFactory;
import com.jiyun.dell.mypandachannel.LiveChinaFragment.bean.Jieqi;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseActivity;
import com.jiyun.dell.mypandachannel.tool.okhttputil.NetWorkCallback;

import java.util.List;

import butterknife.Bind;

public class YuanActivity extends BaseActivity {


    @Bind(R.id.list_yuan)
    ListView listYuan;

    @Override
    protected void initView() {

        HttpFactory.create().get("http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json", null, new NetWorkCallback() {
            @Override
            public void onSuccess(String string) {
                Gson gson = new Gson();
                Jieqi jieqi = gson.fromJson(string, Jieqi.class);
                List<Jieqi.InteractiveBean> interactive = jieqi.getInteractive();

                MyYuanAdapter adapter = new MyYuanAdapter(YuanActivity.this,interactive);
                listYuan.setAdapter(adapter);
            }

            @Override
            public void onError(String e) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yuan;
    }

}
