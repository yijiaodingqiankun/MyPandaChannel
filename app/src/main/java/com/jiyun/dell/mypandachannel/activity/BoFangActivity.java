package com.jiyun.dell.mypandachannel.activity;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseActivity;

import butterknife.Bind;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class BoFangActivity extends BaseActivity {


    @Bind(R.id.jcvp)
    JCVideoPlayer jcvp;

    @Override
    protected void initView() {
//        jcvp.setUp();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bo_fang;
    }


}
