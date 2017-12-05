package com.jiyun.dell.mypandachannel.qq;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

/**
 * Created by DELL zhanghuirong on 2017/11/23.
 */

public abstract class BaseUiListener implements IUiListener {
    @Override
    public void onComplete(Object o) {
//        mBaseMessageText.setText("onComplete:");
//        mMessageText.setText(o.toString());
        doComplete(o);
    }

    private void doComplete(Object o) {

    }

    @Override
    public void onError(UiError uiError) {
        showResult("onError:", "code:" + uiError.errorCode + ", msg:"
                + uiError.errorMessage + ", detail:" + uiError.errorDetail);
    }

    @Override
    public void onCancel() {
        showResult("onCancel", "");
    }

    private void showResult(String onCancel, String s) {

    }

    protected abstract void doComplete(JSONObject values);
}
