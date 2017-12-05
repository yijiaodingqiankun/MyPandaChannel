package com.jiyun.dell.mypandachannel.activity;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseActivity;

import butterknife.Bind;

public class XiangActivity extends BaseActivity {


    @Bind(R.id.web)
    WebView web;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        web.loadUrl(url);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                web.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xiang;
    }


}
