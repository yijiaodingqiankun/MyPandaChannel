package com.jiyun.dell.mypandachannel.activity.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.dell.mypandachannel.R;
import com.jiyun.dell.mypandachannel.base.BaseFragment;

import java.io.IOException;
import java.io.InputStream;
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

import static com.jiyun.dell.mypandachannel.R.id.btn_register;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmailRegFragment extends BaseFragment {
    private String pathurl = "http://reg.cntv.cn/simple/verificationCode.action";
    @Bind(R.id.edit_email)
    EditText editEmail;
    @Bind(R.id.hint_emamil)
    TextView hintEmamil;
    @Bind(R.id.edit_passwrok)
    EditText editPasswrok;
    @Bind(R.id.hint_passwork)
    TextView hintPasswork;
    @Bind(R.id.edit_again_password)
    EditText editAgainPassword;
    @Bind(R.id.hint_again_passord)
    TextView hintAgainPassord;
    @Bind(R.id.edit_yanzhengma)
    EditText editYanzhengma;
    @Bind(R.id.personal_reg_imgcheck)
    ImageView personalRegImgcheck;
    @Bind(R.id.hint_yanzhengma)
    TextView hintYanzhengma;
    @Bind(R.id.xieyi_check)
    CheckBox xieyiCheck;
    @Bind(R.id.personal_reg_xieyi_view)
    TextView personalRegXieyiView;
    @Bind(R.id.hint_xieyi)
    TextView hintXieyi;
    @Bind(btn_register)
    TextView btnRegister;
    private String JSESSIONID = null;

    @Override
    protected void initView() {
//        Glide.with(getActivity()).load(pathurl).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(personalRegImgcheck);

        getimgvfc();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_email_reg;
    }


    @OnClick({R.id.hint_emamil, R.id.hint_passwork, R.id.hint_again_passord, R.id.personal_reg_imgcheck, R.id.hint_yanzhengma, R.id.xieyi_check, R.id.personal_reg_xieyi_view, R.id.hint_xieyi, btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hint_emamil:
                break;
            case R.id.hint_passwork:
                break;
            case R.id.hint_again_passord:
                break;
            case R.id.personal_reg_imgcheck:
//                Glide.with(getActivity()).load(pathurl).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(personalRegImgcheck);
                getimgvfc();
                break;
            case R.id.hint_yanzhengma:
                break;
            case R.id.xieyi_check:
                break;
            case R.id.personal_reg_xieyi_view:
                break;
            case R.id.hint_xieyi:
                break;
            case btn_register:
                submit();
                sendHttpMessageOfMail();
                break;
        }
    }

    private void submit() {
        String emal = editEmail.getText().toString();
        String password = editPasswrok.getText().toString().trim();
        String aginpassword = editAgainPassword.getText().toString().trim();
        String yanzhenma = editYanzhengma.getText().toString().trim();

        if (TextUtils.isEmpty(emal)) {
            Toast.makeText(getActivity(), "邮箱不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(aginpassword)) {
            Toast.makeText(getActivity(), "确认密码不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(yanzhenma)) {
            Toast.makeText(getActivity(), "验证码不能为空", Toast.LENGTH_SHORT).show();
        }else {

        }
    }


    /**
     * 获取图形验证码
     */
    private void getimgvfc() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
            List<Cookie> cookies = new ArrayList<Cookie>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                this.cookies = cookies;

                for (Cookie cook : cookies) {
                    if (cook.name().equals("JSESSIONID")) {
                        JSESSIONID = cook.value();
                    }
                }


            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return cookies;
            }
        }).build();


        Request request = new Request.Builder().url(pathurl).build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            personalRegImgcheck.setImageBitmap(bitmap);
                        }
                    });

                }
            }
        });
    }

    /**
     * 发送邮箱
     */

    private void sendHttpMessageOfMail() {

        try {

            String emal = editEmail.getText().toString().trim();
            String pass = editPasswrok.getText().toString().trim();
            String from = "iPanda.Android";
            String url = "https://reg.cntv.cn/api/register.action" + "?mailAdd="
                    + emal + "&passWd=" + URLEncoder.encode(pass, "UTF-8")
                    + "&verificationCode=" + editYanzhengma + "&addons="
                    + URLEncoder.encode(from, "UTF-8");


            OkHttpClient okHttpClient6 = new OkHttpClient.Builder().build();

            RequestBody body = new FormBody.Builder().build();

            Request request = new Request.Builder().post(body).addHeader("Referer", URLEncoder.encode(from, "UTF-8")).addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8")).addHeader("Cookie", "JSESSIONID=" + JSESSIONID).url(url).build();

            Call call = okHttpClient6.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();

                }
            });


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
