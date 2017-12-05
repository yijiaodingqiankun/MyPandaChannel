package com.jiyun.dell.mypandachannel.activity.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.jiyun.dell.mypandachannel.R.id.edit_imgyanzhengma;
import static com.jiyun.dell.mypandachannel.R.id.edit_phone;


public class PhoneRegFragment extends BaseFragment {
    String from = "https://reg.cntv.cn/login/login.action";
    private String pathurl = "http://reg.cntv.cn/simple/verificationCode.action";
    @Bind(edit_phone)
    EditText editPhone;
    @Bind(R.id.hint_phone)
    TextView hintPhone;
    @Bind(edit_imgyanzhengma)
    EditText editImgyanzhengma;

    @Bind(R.id.personal_reg_imgchecks)
    ImageView personalRegImgchecks;

    @Bind(R.id.hint_imagecheck)
    TextView hintImagecheck;
    @Bind(R.id.edit_phoneyanzhengma)
    EditText editPhoneyanzhengma;
    @Bind(R.id.personal_reg_phonecheck)
    TextView personalRegPhonecheck;
    @Bind(R.id.hint_phonecheck)
    TextView hintPhonecheck;
    @Bind(R.id.edit_inputpasswrod)
    EditText editInputpasswrod;
    @Bind(R.id.hint_password)
    TextView hintPassword;
    @Bind(R.id.xieyi_check)
    CheckBox xieyiCheck;
    @Bind(R.id.personal_reg_xieyi_view)
    TextView personalRegXieyiView;
    @Bind(R.id.hint_xieyi)
    TextView hintXieyi;
    @Bind(R.id.btn_register)
    TextView btnRegister;
    private String JSESSIONID = null;
    private String TAG;
    private String verifycode = null;
    private String uct = null;
    private String mUserSeqId;
    private String mUserId;
    private String mNickName;


    @Override
    protected void initView() {
//        Glide.get(getActivity()).clearMemory();
//        Glide.get(getActivity()).clearDiskCache();
//        Glide.with(getActivity()).load(pathurl).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(personalRegImgchecks);
        getimgvft();
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_youxiang_reg;
    }


    @OnClick({R.id.hint_phone, R.id.personal_reg_imgchecks, R.id.hint_imagecheck, R.id.personal_reg_phonecheck, R.id.hint_phonecheck, R.id.hint_password, R.id.xieyi_check, R.id.personal_reg_xieyi_view, R.id.hint_xieyi, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hint_phone:
                break;
            case R.id.personal_reg_imgchecks:
//                Glide.get(getActivity()).clearMemory();
//                Glide.get(getActivity()).clearDiskCache();

//                Glide.with(getActivity()).load(pathurl).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(personalRegImgchecks).equals(editPhoneyanzhengma.getText().toString().trim());


                getimgvft();
                break;
            case R.id.hint_imagecheck:
                break;
            case R.id.personal_reg_phonecheck:
                try {
                    smsRequest();
                    Toast.makeText(getActivity(), "验证码已发送", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.hint_phonecheck:
                break;
            case R.id.hint_password:
                break;
            case R.id.xieyi_check:
                break;
            case R.id.personal_reg_xieyi_view:
                break;
            case R.id.hint_xieyi:
                break;
            case R.id.btn_register:

                phoneReg();
                break;
        }
    }

    byte[] bytes = null;

    /**
     * 获取图片验证码
     */
    private void getimgvft() {

        OkHttpClient okHttpClient2 = new OkHttpClient.Builder().cookieJar(new CookieJar() {
            List<Cookie> cookies1 = new ArrayList<Cookie>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookies1 = cookies;

                for (Cookie cookie : cookies1) {
                    if (cookie.name().equals("JSESSIONID")) {
                        JSESSIONID = cookie.value();
                    }
                }


            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return cookies1;
            }
        }).build();

        final Request request = new Request.Builder().url(pathurl).build();

        Call call = okHttpClient2.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream string = response.body().byteStream();
                Log.e(TAG, "onResponse: " + string);
                final Bitmap bitmap = BitmapFactory.decodeStream(string);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        personalRegImgchecks.setImageBitmap(bitmap);
                    }
                });
            }
        });


    }


    /**
     * 短信验证码的请求
     */
    private void smsRequest() throws IOException {

        String phoneString = editPhone.getText().toString().trim();
        String phoneyanzhengma = editImgyanzhengma.getText().toString().trim();
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";
        HashMap<String, String> tHeaders = new HashMap<String, String>();
        try {

            tHeaders.put("Referer", URLEncoder.encode(from, "UTF-8"));
            tHeaders.put("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
            tHeaders.put("Cookie", "JSESSIONID=" + JSESSIONID);
        } catch (Exception e) {

        }

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("method", "getRequestVerifiCodeM");
        params.put("mobile", phoneString);
        params.put("verfiCodeType", "1");
        params.put("verificationCode", phoneyanzhengma);


        OkHttpClient ok = new OkHttpClient.Builder().build();

        RequestBody body = new FormBody.Builder().add("method", "getRequestVerifiCodeM").add("mobile", phoneString).add("verfiCodeType", "1").add("verificationCode", phoneyanzhengma).build();

        Request request = new Request.Builder().post(body).url(url).addHeader("Referer", URLEncoder.encode(from, "UTF-8")).addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8")).addHeader("Cookie", "JSESSIONID=" + JSESSIONID).build();

        Call call = ok.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e(TAG, "onResponse: " + string);
            }
        });


    }


    /***
     * 手机号注册的请求
     */
    private void phoneReg() {
        String url = "https://reg.cntv.cn/regist/mobileRegist.do";
        String phonenum = editPhone.getText().toString().trim();
        String phoneyanzhengma = editPhoneyanzhengma.getText().toString().trim();
        String password = editInputpasswrod.getText().toString().trim();

        //请求头
        HashMap<String, String> head = new HashMap<>();
        try {
            //推荐人
            head.put("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
            //用户代理
            head.put("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }

        //参数
        HashMap<String, String> params = new HashMap<>();
        params.put("method", "saveMobileRegisterM");
        params.put("mobile", phonenum);
        params.put("verfiCode", phoneyanzhengma);
        try {
            params.put("passWd", URLEncoder.encode(password, "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }

        params.put("verfiCodeType", "1");
        try {
            //插件
            params.put("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        RequestBody body = null;
        try {
            body = new FormBody.Builder().add("method", "saveMobileRegisterM").add("mobile", phonenum).add("verfiCode", phoneyanzhengma).add("passWd", URLEncoder.encode(password, "UTF-8")).add("verfiCodeType", "1").add("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8")).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Request request = null;
        try {
            request = new Request.Builder().method("POST", body).addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8")).addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8")).url(url).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.code() == HttpURLConnection.HTTP_OK) {
                    login();
                }
            }
        });


    }

    private void login() {
        String phonenum = editPhone.getText().toString().trim();
        String password = editInputpasswrod.getText().toString().trim();

        try {
            String loginurl = from + "?username="
                    + URLEncoder.encode(phonenum, "UTF-8")
                    + "&password=" + password
                    + "&service=client_transaction" + "&from="
                    + URLEncoder.encode(from, "UTF-8");


            OkHttpClient okHttpClient5 = new OkHttpClient.Builder().cookieJar(new CookieJar() {
                List<Cookie> cookies = new ArrayList<Cookie>();

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    this.cookies = cookies;
                    for (Cookie cook : cookies) {
                        if (cook.name().equals("JSESSIONID")) {
                            JSESSIONID = cook.value();
                        } else if (cook.name().equals("verifycode")) {
                            verifycode = cook.value();

                            Log.e(TAG, "verifycode: ---------" + verifycode);
                        } else if (cook.name().equals("uct")) {
                            uct = cook.value();
                        }
                    }
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    return cookies;
                }
            }).build();

            Request request = new Request.Builder()
                    .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CYNTV_MOBILE", "UTF-8"))
                    .url(loginurl)
                    .build();


            Call call = okHttpClient5.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();

                    try {
                        JSONObject object = new JSONObject(string);
                        if (object.getString("errType").equals("0")) {
                            if (object.has("user_seq_id")) {
                                mUserSeqId = object.getString("user_seq_id");

                                Log.e(TAG, "user_seq_id:---- " + mUserSeqId);
                            }
                            if (object.has("usrid")) {
                                mUserId = object.getString("usrid");

                                Log.e(TAG, "usrid:---- " + mUserId);
                            }
                        } else {
                            String errMsg = object.getString("errMsg");

                            Log.e(TAG, "errMsg:---- " + errMsg);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    if (response.code() == 200) {
                        //获取昵称
                        getUserTicket();
                    }

                }
            });


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ;

    }


    /**
     * 获取用户昵称
     */
    private void getUserTicket() {
        String client = "http://cbox_mobile.regclientuser.cntv.cn";
        String url = "http://my.cntv.cn/intf/napi/api.php" + "?client="
                + "cbox_mobile" + "&method=" + "user.getNickName"
                + "&userid=" + mUserSeqId;

        OkHttpClient okHttpClient7 = new OkHttpClient.Builder().build();

        RequestBody body = new FormBody.Builder().build();

        Request request = null;
        try {


            request = new Request.Builder()
                    .post(body)
                    .addHeader("Referer", URLEncoder.encode(client, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", "verifycode=" + verifycode)
                    .url(url).build();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Call call = okHttpClient7.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                if (response.code() == HttpURLConnection.HTTP_OK) {
                    try {

                        JSONObject ob = new JSONObject(string);
                        if (ob.getString("code").equals("0")) {
                            if (ob.has("content")) {
                                JSONObject content = ob.getJSONObject("content");
                                if (content.has("nickname")) {
                                    mNickName = content.getString("nickname");

                                } else {
                                    mNickName = "default";
                                }

                            }
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

}
