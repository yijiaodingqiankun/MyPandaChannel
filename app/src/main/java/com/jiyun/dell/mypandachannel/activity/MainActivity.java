package com.jiyun.dell.mypandachannel.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.adapter.MyVpAdapter;
import com.jiyun.dell.mypandachannel.base.BaseActivity;
import com.jiyun.dell.mypandachannel.customize.MyAppTitle;
import com.jiyun.dell.mypandachannel.mainpresenter.MainPresenter;
import com.jiyun.dell.mypandachannel.mainpresenter.MainPresenterInf;
import com.jiyun.dell.mypandachannel.mainview.MainViewInf;

import java.util.List;

import butterknife.Bind;

import static com.jiyun.dell.mypandachannel.R.id.rb_home;

public class MainActivity extends BaseActivity implements MainViewInf, RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.myNewAppTitle)
    MyAppTitle myNewAppTitle;
    @Bind(R.id.vp)
    ViewPager vp;
    @Bind(rb_home)
    RadioButton rbHome;
    @Bind(R.id.rb_live)
    RadioButton rbLive;
    @Bind(R.id.rb_video)
    RadioButton rbVideo;
    @Bind(R.id.rb_pandabord)
    RadioButton rbPandabord;
    @Bind(R.id.rb_livechina)
    RadioButton rbLivechina;
    @Bind(R.id.rg)
    RadioGroup rg;
    private TextView biaoti, tupian, right, tvright;

    @Override
    protected void initView() {
//        biaoti = myNewAppTitle.findViewById(R.id.tvCenterTitle);
//        tupian = myNewAppTitle.findViewById(R.id.tupian);
//        right = myNewAppTitle.findViewById(R.id.ivRightComplete);
//        tvright = myNewAppTitle.findViewById(R.id.tvRightComplete);


        MainPresenterInf mainPresenterInf = new MainPresenter(this);
        mainPresenterInf.mainViewTomainModel();
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void upData(List<Fragment> list) {

        MyVpAdapter myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(myVpAdapter);
        vp.setCurrentItem(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                vp.setCurrentItem(0);
                break;
            case R.id.rb_live:
                vp.setCurrentItem(1);
//                biaoti.setVisibility(View.VISIBLE);
//                biaoti.setText("熊猫观察");
//                tupian.setVisibility(View.INVISIBLE);
//                right.setVisibility(View.INVISIBLE);
//                tvright.setVisibility(View.INVISIBLE);

                break;
            case R.id.rb_video:
                vp.setCurrentItem(2);
//                biaoti.setVisibility(View.VISIBLE);
//                biaoti.setText("熊猫文化");
//                tupian.setVisibility(View.INVISIBLE);
//                right.setVisibility(View.INVISIBLE);
//                tvright.setVisibility(View.INVISIBLE);
                break;
            case R.id.rb_pandabord:
                vp.setCurrentItem(3);
//                biaoti.setVisibility(View.VISIBLE);
//                biaoti.setText("熊猫直播");
//                tupian.setVisibility(View.INVISIBLE);
//                right.setVisibility(View.INVISIBLE);
//                tvright.setVisibility(View.INVISIBLE);
                break;
            case R.id.rb_livechina:
                vp.setCurrentItem(4);
//                biaoti.setVisibility(View.VISIBLE);
//                biaoti.setText("直播中国");
//                tupian.setVisibility(View.INVISIBLE);
//                right.setVisibility(View.INVISIBLE);
//                tvright.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
