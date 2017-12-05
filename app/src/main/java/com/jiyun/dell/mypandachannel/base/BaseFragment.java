package com.jiyun.dell.mypandachannel.base;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.dell.mypandachannel.R;

import butterknife.ButterKnife;

/**
 * Created by DELL zhanghuirong on 2017/11/20.
 */

public abstract class BaseFragment extends Fragment {
    private Context context;
    private int dialogNum;
    private Dialog loadDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected abstract void initView();

    protected abstract int getLayoutId();


    public void showLoadingDialog() {
        dialogNum++;
        if (loadDialog != null && loadDialog.isShowing()) {
            loadDialog.dismiss();
            loadDialog = null;

        }
        loadDialog = new Dialog(getActivity(), R.style.dialog);
        loadDialog.setCanceledOnTouchOutside(false);
        loadDialog.setContentView(R.layout.layout_dailog);
        loadDialog.show();
    }

    /**
     * 隐藏正在加载的进度条
     *
     */
    public void dismissLoadDialog() {
        dialogNum--;
        if (dialogNum > 0) {
            return;
        }

        if (loadDialog != null && loadDialog.isShowing() == true) {
            loadDialog.dismiss();
            loadDialog = null;
        }
    }


    /**
     * 判断当前手机是否有网络，包括WiFi
     */
    public boolean isConnected() {

        //连接管理器
        ConnectivityManager connectivity = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            //获取网络连接管理对象
            NetworkInfo info = connectivity.getActiveNetworkInfo();

            if (info != null && info.isConnected()) {
                //判断当前网络是否已经连接
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }


        return false;
    }
}
