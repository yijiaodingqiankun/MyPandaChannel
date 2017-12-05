package com.jiyun.dell.mypandachannel.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseActivity;

import java.io.IOException;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UpdateNicknameActivity extends BaseActivity {

    public final static String BASE_URL = "http://my.cntv.cn/intf/napi/api.php";
    @Bind(R.id.et_nickname)
    EditText etNickname;
    @Bind(R.id.black)
    ImageView black;
    @Bind(R.id.save)
    TextView save;
    private String usrid;
    private int flag;


    @Override
    protected void initView() {
        Intent intent = getIntent();
        String nicheng = intent.getStringExtra("nicheng");
        etNickname.setText(nicheng);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_nickname;
    }


    @OnClick({R.id.black, R.id.save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.black:
                finish();
                break;

            case R.id.save:
                String nickname = etNickname.getText().toString().trim();
//                571276601511749752032
                usrid = Shar.getInstance().getEdit("usrid", "0");
                String verifycode = Shar.getInstance().getEdit("verifycode", "0");
                String errType = Shar.getInstance().getEdit("errType", "0");

//                if (TextUtils.isEmpty(verifycode)) {

                Upload.getInstance().postNickName(BASE_URL, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        if (response.code() == 200) {
                            Gson gson = new Gson();
                            Code code = gson.fromJson(string, Code.class);
                            int code1 = code.getCode();
                            if (code1 == 0) {
                                flag = 1;//上传成功 显示“我知道啦”提示框
                                ToastUtils.showShort(UpdateNicknameActivity.this, "您的昵称已提交审核\\n\\n请稍后回来确认吧");
                            } /*else {
                                //根据返回errcode 判断cookie失效 提示用户重新登录
                                if (code1 == -100 && usrid != null) {
                                      ToastUtils.showShort(UpdateNicknameActivity.this, "您的登录已过期，请重新登录");

                                } else {
                                    //提示服务器返回的错误信息
                                    ToastUtils.showShort(UpdateNicknameActivity.this, code.getError());
                                }
                            }*/
                        }
                    }
                }, usrid, nickname);

//                }
                break;
        }
    }





}
