package com.jiyun.dell.mypandachannel.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.crach.App;
import com.jiyun.dell.mypandachannel.customize.MyAppTitle;

import butterknife.ButterKnife;

/**
 * Created by DELL zhanghuirong on 2017/11/20.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private MyAppTitle mNewAppTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.activity = this;
        ButterKnife.bind(this);
        initView();
//        setMyAppTitle();
    }

    protected abstract void initView();

    protected abstract int getLayoutId();

    protected void setMyAppTitle() {
        mNewAppTitle = (MyAppTitle) this.findViewById(R.id.myNewAppTitle);

        mNewAppTitle.initViewsVisible(true, false, true, true);

//        mNewAppTitle.setAppTitle("返回");
//        mNewAppTitle.setRightTitle("提交");
        mNewAppTitle.setOnLeftButtonClickListener(new MyAppTitle.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
//                onBackPrd();
                Log.e("TAG", "点击了返回按钮");
            }
        });
        mNewAppTitle.setOnRightButtonClickListener(new MyAppTitle.OnRightButtonClickListener() {
            @Override
            public void OnRightButtonClick(View v) {
                //TODO
//
                Log.e("TAG", "点击了右边按钮");
            }
        });
    }
}
