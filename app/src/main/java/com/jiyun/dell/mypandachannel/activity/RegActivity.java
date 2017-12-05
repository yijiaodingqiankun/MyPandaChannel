package com.jiyun.dell.mypandachannel.activity;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.activity.fragment.EmailRegFragment;
import com.jiyun.dell.mypandachannel.activity.fragment.PhoneRegFragment;
import com.jiyun.dell.mypandachannel.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class RegActivity extends BaseActivity {


    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.phone_reg)
    TextView phoneReg;
    @Bind(R.id.Email_reg)
    TextView EmailReg;
    @Bind(R.id.framelayout)
    FrameLayout framelayout;
    @Bind(R.id.shou)
    View shou;//底部导航线
    @Bind(R.id.emal)
    View emal;//底部导航线
    private FragmentManager manager;

    @Override
    protected void initView() {
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.framelayout, new PhoneRegFragment()).commit();

        shou.setVisibility(View.VISIBLE);
        emal.setVisibility(View.INVISIBLE);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reg;
    }


    @OnClick({R.id.img_back, R.id.phone_reg, R.id.Email_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.phone_reg:

                manager.beginTransaction().add(R.id.framelayout, new PhoneRegFragment()).commit();

                shou.setVisibility(View.VISIBLE);//底部导航线
                emal.setVisibility(View.INVISIBLE);//底部导航线
                break;
            case R.id.Email_reg:
                manager.beginTransaction().replace(R.id.framelayout, new EmailRegFragment()).commit();

                shou.setVisibility(View.INVISIBLE);//底部导航线
                emal.setVisibility(View.VISIBLE);//底部导航线
                break;
        }
    }


}
