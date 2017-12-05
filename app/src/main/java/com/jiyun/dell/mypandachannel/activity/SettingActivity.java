package com.jiyun.dell.mypandachannel.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {


    @Bind(R.id.img)
    ImageView img;
    @Bind(R.id.pe_set_push_view)
    ImageView peSetPushView;
    @Bind(R.id.pe_set_play_view)
    ImageView peSetPlayView;
    @Bind(R.id.set_cache_size_tv)
    TextView setCacheSizeTv;
    @Bind(R.id.personal_set_delete_cache_layout)
    RelativeLayout personalSetDeleteCacheLayout;
    @Bind(R.id.personal_set_fankui_layout)
    RelativeLayout personalSetFankuiLayout;
    @Bind(R.id.personal_set_udpate_layout)
    RelativeLayout personalSetUdpateLayout;
    @Bind(R.id.personal_set_ping_layout)
    RelativeLayout personalSetPingLayout;
    @Bind(R.id.personal_set_about_layout)
    RelativeLayout personalSetAboutLayout;

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }


    @OnClick({R.id.img, R.id.pe_set_push_view, R.id.pe_set_play_view, R.id.set_cache_size_tv, R.id.personal_set_delete_cache_layout, R.id.personal_set_fankui_layout, R.id.personal_set_udpate_layout, R.id.personal_set_ping_layout, R.id.personal_set_about_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img:
                finish();
                break;
            case R.id.pe_set_push_view:
                break;
            case R.id.pe_set_play_view:
                break;
            case R.id.set_cache_size_tv:
                break;
            case R.id.personal_set_delete_cache_layout:
                break;
            case R.id.personal_set_fankui_layout:
                break;
            case R.id.personal_set_udpate_layout:
                break;
            case R.id.personal_set_ping_layout:
                break;
            case R.id.personal_set_about_layout:
                break;
        }
    }
}
