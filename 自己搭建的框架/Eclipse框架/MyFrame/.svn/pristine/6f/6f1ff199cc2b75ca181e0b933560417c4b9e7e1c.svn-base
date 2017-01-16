package com.alnton.myframe.wxapi;

import org.json.JSONObject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import cn.jpush.android.api.JPushInterface;

import com.alnton.myFrameCore.util.TelephoneUtil;
import com.alnton.myframe.R;
import com.alnton.myframe.application.Session;
import com.alnton.myframe.config.Config;
import com.alnton.myframe.config.FusionCode;
import com.alnton.myframe.entity.http.ResponseEntity;
import com.alnton.myframe.ui.BaseActivity;
import com.alnton.myframe.util.ProgressDialogUtil;
import com.alnton.myframe.util.ToastUtil;
import com.alnton.myframe.util.http.HttpInterface;
import com.alnton.myframe.util.http.JsonRequestParams;
import com.alnton.myframe.util.http.RequestCallback;
import com.google.gson.reflect.TypeToken;
import com.tencent.connect.UserInfo;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/**
 * <微信登录、支付的回调页>
 * @author  王乾州
 * @createon 2016-8-13
 */
public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler
{
    /**
     * 微信返回的昵称，头像地址，openid
     */
    private String petName = "", headPic = "", openid = "";
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        /**
         * 必须调用此句话  
         */
        Session.getInstance().wxAPI.handleIntent(getIntent(), this);
    }
    
    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        
        /**
         * 必须调用此句话  
         */
        Session.getInstance().wxAPI.handleIntent(intent, this);
    }
    
    /**
     * 微信发送请求到第三方应用时，会回调到该方法
     */
    @Override
    public void onReq(BaseReq req)
    {
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
    public void onResp(BaseResp resp)
    {
        if (resp.errCode == BaseResp.ErrCode.ERR_OK)
        {
            if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX)
            {
                /* 支付成功 */
                sendBroadcast(new Intent(FusionCode.getInstance().PAYSUCCESSUPDATETAB_ACTION));
                
                // 跳转到支付成功界面
                //                Bundle bundle = new Bundle();
                //                bundle.putString("orderCode", CacheSession.getInstance().orderCode);
                
                //                MyFrameResourceTools.getInstance().startActivity(mContext, PaySuccessActivity.class, bundle);
                finish();
            }
            else
            {
                /* 登录 用户同意 获取到code之后，需要调用接口获取到access_token */
                SendAuth.Resp sendResp = (SendAuth.Resp)resp;
                if (null != sendResp)
                {
                    getToken(sendResp.code);
                }
            }
        }
        else
        {
            int result = 0;
            switch (resp.errCode)
            {
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
    private void getToken(final String code)
    {
        new AsyncTask<Void, Integer, Void>()
        {
            @Override
            protected void onPreExecute()
            {
                ProgressDialogUtil.instance.showProgressDialog(mContext);
                
                super.onPreExecute();
            }
            
            @Override
            protected Void doInBackground(Void... params)
            {
                String content = HttpInterface.instance.onGet(WXConstants.getTokenByCode + "&code=" + code);
                try
                {
                    JSONObject jsonObject = new JSONObject(content);
                    if (!jsonObject.isNull("access_token") && !jsonObject.isNull("openid"))
                    {
                        /**
                         * 获取到token和openID之后，调用此接口得到身份信息  
                         */
                        String userInfoContent =
                            HttpInterface.instance.onGet(WXConstants.getUserInfo + "access_token="
                                + jsonObject.getString("access_token") + "&openid=" + jsonObject.getString("openid"));
                        
                        JSONObject userInfoObject = new JSONObject(userInfoContent);
                        
                        if (!userInfoObject.isNull("nickname"))
                        {
                            petName = userInfoObject.getString("nickname");
                        }
                        
                        if (!userInfoObject.isNull("headimgurl"))
                        {
                            headPic = userInfoObject.getString("headimgurl");
                        }
                        openid = jsonObject.getString("openid");
                    }
                    else
                    {
                        Looper.prepare();
                        ToastUtil.instance.showToast(mContext, R.string.returnError);
                        Looper.loop();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    
                    Looper.prepare();
                    ToastUtil.instance.showToast(mContext, R.string.returnError);
                    Looper.loop();
                }
                return null;
                
            }
            
            @Override
            protected void onPostExecute(Void result)
            {
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
    private void loginThird()
    {
        JsonRequestParams params = new JsonRequestParams();
        params.put("applyKey", openid);
        params.put("petName", petName);
        params.put("headPic", headPic);
        params.put("loginType", "3");
        params.put("regType", "2");
        params.put("deviceNo", TelephoneUtil.getInstance().getIMEI(mContext));
        params.put("loginIp", TelephoneUtil.getInstance().getIPAddress(mContext));
        params.put("regProvince", "");
        params.put("regCity", "");
        
        HttpInterface.instance.onPostWithJson(mContext, Config.URLConfig.LOGIN_THIRD_URL, params, new RequestCallback<UserInfo>(
            mContext, new TypeToken<ResponseEntity<UserInfo>>()
            {
            }.getType())
        {
            @Override
            public void onSuccess(final UserInfo info)
            {
                super.onSuccess(info);
                
                /**
                 * 注册极光推送别名
                 */
                JPushInterface.setAlias(mContext, TelephoneUtil.getInstance().getIMEI(mContext), null);
                finish();
                Session.getInstance().removeActivityByName("LoginActivity");
            }
        });
    }
}