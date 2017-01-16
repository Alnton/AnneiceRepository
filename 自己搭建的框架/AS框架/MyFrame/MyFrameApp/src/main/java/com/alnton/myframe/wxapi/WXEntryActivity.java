package com.alnton.myframe.wxapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;

import com.alnton.myframe.R;
import com.alnton.myframe.application.Session;
import com.alnton.myframe.config.Config;
import com.alnton.myframe.entity.user.UserInfo;
import com.alnton.myframe.ui.BaseActivity;
import com.alnton.myframecore.okhttp.OKHttpUtil;
import com.alnton.myframecore.okhttp.callback.ResponseEntity;
import com.alnton.myframecore.okhttp.callback.ResultCallback;
import com.alnton.myframecore.okhttp.request.RequestParams;
import com.alnton.myframecore.util.TelephoneUtil;
import com.alnton.myframecore.view.util.ProgressDialogUtil;
import com.alnton.myframecore.view.util.ToastUtil;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * <微信登录以及其他和微信相关的操作（不包括微信支付）的回调页>
 *
 * @author 王乾州
 * @createon 2016-8-13
 */
public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    /**
     * 微信返回的昵称，头像地址，openid
     */
    private String petName = "", headPic = "", openid = "";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 必须调用此句话  
         */
        Session.getInstance().wxAPI.handleIntent(getIntent(), this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        /**
         * 必须调用此句话  
         */
        setIntent(intent);
        Session.getInstance().wxAPI.handleIntent(intent, this);
    }

    /**
     * 微信发送请求到第三方应用时，会回调到该方法
     */
    @Override
    public void onReq(BaseReq req) {
    }

    /**
     * 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
     * 在此处得到Code之后调用https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     * 获取到token和openID。之后再调用https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID 获取用户个人信息
     * ERR_OK = 0(用户同意)
     * ERR_AUTH_DENIED = -4（用户拒绝授权）
     * ERR_USER_CANCEL = -2（用户取消）
     */
    @Override
    public void onResp(BaseResp resp) {
        if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
             /* 登录 用户同意 获取到code之后，需要调用接口获取到access_token */
            SendAuth.Resp sendResp = (SendAuth.Resp) resp;
            if (null != sendResp) {
                getToken(sendResp.code);
            }
        } else {
            int result = 0;
            switch (resp.errCode) {
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    result = R.string.errcode_cancel;
                    break;

                case BaseResp.ErrCode.ERR_AUTH_DENIED:
                    result = R.string.errcode_deny;
                    break;

                default:
                    result = R.string.errcode_unknown;
                    break;
            }
            ToastUtil.instance.showToast(mContext, result);
            finish();
        }
    }

    /**
     * 这个方法会取得accesstoken 和 openID
     */
    private void getToken(final String code) {
        new AsyncTask<Void, Integer, Void>() {
            @Override
            protected void onPreExecute() {
                ProgressDialogUtil.instance.showProgressDialog(mContext, null);

                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {
                String content = OKHttpUtil.instance.onGetString(WXConstants.getTokenByCode + "&code=" + code);
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    if (!jsonObject.isNull("access_token") && !jsonObject.isNull("openid")) {
                        /**
                         * 获取到token和openID之后，调用此接口得到身份信息  
                         */
                        String userInfoContent =
                                OKHttpUtil.instance.onGetString(WXConstants.getUserInfo + "access_token="
                                        + jsonObject.getString("access_token") + "&openid=" + jsonObject.getString("openid"));

                        JSONObject userInfoObject = new JSONObject(userInfoContent);

                        if (!userInfoObject.isNull("nickname")) {
                            petName = userInfoObject.getString("nickname");
                        }

                        if (!userInfoObject.isNull("headimgurl")) {
                            headPic = userInfoObject.getString("headimgurl");
                        }
                        openid = jsonObject.getString("openid");
                    } else {
                        Looper.prepare();
                        ToastUtil.instance.showToast(mContext, R.string.returnError);
                        Looper.loop();
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                    Looper.prepare();
                    ToastUtil.instance.showToast(mContext, R.string.returnError);
                    Looper.loop();
                }
                return null;

            }

            @Override
            protected void onPostExecute(Void result) {
                ProgressDialogUtil.instance.dismissProgressDialog();

                /**
                 * 调用第三方登录接口
                 */
                loginThird();

                super.onPostExecute(result);
            }
        }.execute();
    }

    /**
     * 获取到身份信息 之后调用第三方登录接口
     */
    private void loginThird() {
        RequestParams params = new RequestParams();
        params.put("applyKey", openid);
        params.put("petName", petName);
        params.put("headPic", headPic);
        params.put("loginType", "3");
        params.put("regType", "2");
        params.put("deviceNo", TelephoneUtil.getInstance().getIMEI(mContext));
        params.put("loginIp", TelephoneUtil.getInstance().getIPAddress(mContext));
        params.put("regProvince", "");
        params.put("regCity", "");

        OKHttpUtil.instance.onPostParams(Config.URLConfig.LOGIN_THIRD_URL, params, new ResultCallback<ResponseEntity<UserInfo>>() {
            @Override
            public void onResponse(ResponseEntity<UserInfo> info) {
/**
 * 注册极光推送别名
 */
                JPushInterface.setAlias(mContext, TelephoneUtil.getInstance().getIMEI(mContext), null);
                finish();
                Session.getInstance().removeActivityByName("LoginActivity");
            }
        });
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("WXEntry Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}