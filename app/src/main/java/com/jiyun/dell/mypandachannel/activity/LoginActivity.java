package com.jiyun.dell.mypandachannel.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.activity.fragment.loginbean.Photo;
import com.jiyun.dell.mypandachannel.base.BaseActivity;
import com.jiyun.dell.mypandachannel.qq.BaseUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
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

import static android.provider.UserDictionary.Words.APP_ID;

public class LoginActivity extends BaseActivity {
    public final static String BASE_URL = "http://my.cntv.cn/intf/napi/api.php";
    public static final String CLIENT = "ipanda_mobile";
    public static final String USER_AGENT = "CNTV_APP_CLIENT_CYNTV_MOBILE";
    public final static String LOGIN_URL = "https://reg.cntv.cn/login/login.action";
    private String postlogin = "https://reg.cntv.cn/login/login.action";
    @Bind(R.id.weixin)
    ImageButton weixin;
    @Bind(R.id.qq)
    ImageButton qq;
    @Bind(R.id.sina)
    ImageButton sina;
    @Bind(R.id.login_name)
    EditText loginName;
    @Bind(R.id.login_pass)
    EditText loginPass;
    @Bind(R.id.forget_pass)
    TextView forgetPass;
    @Bind(R.id.login_login)
    Button loginLogin;
    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.reg_text)
    TextView regText;
    private Tencent mTencent;
    private String SCOPE = "get_user_info";
    private String mNickName;
    private String JSESSIONID = null;
    private String verifycode;
    private String uct;
    private String userface;


    @Override
    protected void initView() {
// Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
        // 其中APP_ID是分配给第三方应用的appid，类型为String。
        mTencent = Tencent.createInstance(APP_ID, this.getApplicationContext());
        // 1.4版本:此处需新增参数，传入应用程序的全局context，可通过activity的getApplicationContext方法获取
        // 初始化视图
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTencent.onActivityResult(requestCode, resultCode, data);
    }


    @OnClick({R.id.img_back, R.id.reg_text, R.id.weixin, R.id.qq, R.id.sina, R.id.forget_pass, R.id.login_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.reg_text:
                Intent intent = new Intent(this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.weixin:
                break;
            case R.id.qq:
                doLogin();
                break;
            case R.id.sina:
                break;
            case R.id.forget_pass:
                break;
            case R.id.login_login:
                login();

                break;
        }
    }

    private void doLogin() {
        IUiListener listener = new BaseUiListener() {
            @Override
            protected void doComplete(JSONObject values) {
//                updateLoginButton();
            }
        };
        mTencent.login(this, SCOPE, listener);
    }

    private void updateLoginButton() {

    }

    /***
     * 登录
     */
    private void login() {
        String name = loginName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        final String pass = loginPass.getText().toString().trim();
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        OkHttpClient okHttpClient3 = new OkHttpClient.Builder().cookieJar(new CookieJar() {
            List<Cookie> cookies = new ArrayList<Cookie>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                this.cookies = cookies;

                for (Cookie cookie : cookies) {
                    if ("JSESSIONID".equals(cookie.name())) {
                        JSESSIONID = cookie.value();
                    } else if ("verifycode".equals(cookie.name())) {
                        verifycode = cookie.value();
                        Shar.getInstance().setEdit("verifycode",verifycode);
                    } else if ("uct".equals(cookie.name())) {
                        uct = cookie.value();
                    }
                }

            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return cookies;
            }
        }).build();


        RequestBody body = new FormBody.Builder()
                .add("from", LOGIN_URL)
                .add("service", "client_transaction")
                .add("username", name)
                .add("password", pass)
                .build();

        final Request request = new Request.Builder()
                .post(body)
                .addHeader("Referer", LOGIN_URL)
                .addHeader("User-Agent", USER_AGENT)
                .url(LOGIN_URL)
                .build();

        Call call = okHttpClient3.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                if (response.code() == 200) {

                    Gson gson = new Gson();
                    Photo photo = gson.fromJson(string, Photo.class);
                    String errMsg = photo.getErrMsg();
                    String usrid = photo.getUsrid();
                    String user_seq_id = photo.getUser_seq_id();
                    String errType = photo.getErrType();
                    List<?> sso = photo.getSso();
                    String ticket = photo.getTicket();
                    String timestamp = photo.getTimestamp();


                    Shar shar = Shar.getInstance();
                    shar.setEdit("errMsg", errMsg);
                    shar.setEdit("usrid", usrid);
                    shar.setEdit("user_seq_id", user_seq_id);
                    shar.setEdit("errType", errType);
//                    shar.setEdit("sso", sso);
                    shar.setEdit("ticket", ticket);
                    shar.setEdit("timestamp", timestamp);


//                    getNickNameAndFace(usrid);
                    //获取昵称
                    getUserTicket(user_seq_id);
                    //获取头像
                    getUserface(user_seq_id);




                }


            }
        });


    }

    /**
     * 获取昵称
     */
    private void getUserTicket(String user_seq_id) {

        String client = "http://cbox_mobile.regclientuser.cntv.cn";
        String url = "http://my.cntv.cn/intf/napi/api.php" + "?client="
                + "cbox_mobile" + "&method=" + "user.getNickName"
                + "&userid=" + user_seq_id;


        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Request request = null;
        try {
            request = new Request.Builder()
                    .addHeader("Referer", URLEncoder.encode(client, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode(
                            "CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", "verifycode=" + verifycode)
                    .url(url)
                    .build();


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
                String string = response.body().string();

                if (response.code() == 200) {
                    try {
                        JSONObject jsonObject = new JSONObject(string);
                        if (jsonObject.getString("code").equals("0")) {
                            if (jsonObject.has("content")) {
                                JSONObject contentJSONObject = jsonObject
                                        .getJSONObject("content");
                                if (contentJSONObject.has("nickname")) {
                                    mNickName = contentJSONObject
                                            .getString("nickname");
                                    Shar.getInstance().setEdit("mNickName",mNickName);
                                } else {
                                    mNickName = "default";
                                }
                            }
                        } else {
                            String codeErrorString = jsonObject.getString("error");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 获取头像
     *
     * @param user_seq_id
     */

    private void getUserface(String user_seq_id) {


        String client = "http://cbox_mobile.regclientuser.cntv.cn";
        String url = "http://my.cntv.cn/intf/napi/api.php" + "?client="
                + "cbox_mobile" + "&method=" + "user.getNickNameAndFace"
                + "&userid=" + user_seq_id;


        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Request request = null;
        try {
            request = new Request.Builder()
                    .addHeader("Referer", URLEncoder.encode(client, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode(
                            "CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", "verifycode=" + verifycode)
                    .url(url)
                    .build();


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
                String string = response.body().string();

                if (response.code() == 200) {
                    try {
                        JSONObject jsonObject = new JSONObject(string);
                        if (jsonObject.getString("code").equals("0")) {
                            if (jsonObject.has("content")) {
                                JSONObject contentJSONObject = jsonObject
                                        .getJSONObject("content");
                                if (contentJSONObject.has("userface")) {
                                    userface = contentJSONObject
                                            .getString("userface");
                                    Shar.getInstance().setEdit("userface",userface);
                                } else {
                                    userface = "default";
                                }
                            }
                        } else {
                            String codeErrorString = jsonObject.getString("error");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }




                    Intent intent = new Intent();
                    setResult(200, intent);
                    intent.putExtra("photos", userface);
                    intent.putExtra("nicheng", mNickName);
                    finish();
                }
            }
        });
    }

    /**
     * 获取用户昵称和头像
     */
    private void getNickNameAndFace(String userId) {
        OkHttpClient okHttpClient4 = new OkHttpClient.Builder().build();

        RequestBody body = new FormBody.Builder()
                .add("client", CLIENT)
                .add("method", "user.getNickNameAndFace")
                .add("userid", userId)
                .build();

        Request request = new Request.Builder().post(body).url(BASE_URL).build();

        Call call = okHttpClient4.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                Log.e("onResponse: -----------", string);
                if (response.code() == HttpURLConnection.HTTP_OK) {

//                    Gson gson = new Gson();
//                    FaceandName faceandName = gson.fromJson(string, FaceandName.class);
//                    FaceandName.ContentBean content = faceandName.getContent();
//                    String userface = content.getUserface();
//
//
//                    Intent intent = new Intent();
//                    setResult(200, intent);
//                    intent.putExtra("photos", userface);
//                    intent.putExtra("nicheng",mNickName);
//                    finish();
                }


            }
        });


    }




   /* private void  loginErrorMsg(String errtype){
        if (errtype.equals("105")) {
            mTxtTishiPassword.setText("密码错误，请重输");
        }
        if (errtype.equals("104")) {
            mTxtTishiAccount.setText("该账号未注册。");
        }
        if (errtype.equals("106")) {
            mTxtTishiAccount.setText("很抱歉，您的账号还没有激活，请激活后再登录。");
        }
        if (errtype.equals("102")) {
            mTxtTishiAccount.setText("缺少参数");
        }

    }*/

}
