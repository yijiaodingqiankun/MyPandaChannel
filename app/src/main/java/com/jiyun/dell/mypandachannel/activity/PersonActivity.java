package com.jiyun.dell.mypandachannel.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonActivity extends BaseActivity {


    @Bind(R.id.person_img)
    CircleImageView personImg;
    @Bind(R.id.person_text)
    TextView personText;
    @Bind(R.id.login)
    RelativeLayout login;
    @Bind(R.id.person_history_img)
    ImageView personHistoryImg;
    @Bind(R.id.guankan_history)
    RelativeLayout guankanHistory;
    @Bind(R.id.person_shoucang_img)
    ImageView personShoucangImg;
    @Bind(R.id.my_shoucang)
    RelativeLayout myShoucang;
    @Bind(R.id.person_set_img)
    ImageView personSetImg;
    @Bind(R.id.set)
    RelativeLayout set;
    @Bind(R.id.img_back)
    ImageView imgBack;
    private String userface;
    private String mNickName;


    @Override
    protected void initView() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_person;
    }


    @OnClick({R.id.login, R.id.guankan_history, R.id.my_shoucang, R.id.set, R.id.img_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:

                if (TextUtils.equals(mNickName, userface)) {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivityForResult(intent, 10086);
                } else {
                    String mNickName = Shar.getInstance().getEdit("mNickName", "");
                    String userface = Shar.getInstance().getEdit("userface", "");
                    Intent intent = new Intent(this, PersonalInformation.class);
                    intent.putExtra("photo", userface);
                    intent.putExtra("nicheng", mNickName);
                    startActivity(intent);
                }
            case R.id.guankan_history:
                break;
            case R.id.my_shoucang:
                break;
            case R.id.set:
                Intent intent1 = new Intent(this, SettingActivity.class);
                startActivity(intent1);
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10086 && resultCode == 200) {
            userface = data.getStringExtra("photos");
            mNickName = data.getStringExtra("nicheng");
            Glide.with(PersonActivity.this).load(userface).into(personImg);
            personText.setText(mNickName);
        }


    }
}
