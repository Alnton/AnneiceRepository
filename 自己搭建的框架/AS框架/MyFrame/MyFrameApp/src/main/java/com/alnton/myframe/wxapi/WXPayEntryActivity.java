package com.alnton.myframe.wxapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.alnton.myframe.application.CacheSession;
import com.alnton.myframe.application.Session;
import com.alnton.myframe.ui.BaseActivity;
import com.alnton.myframecore.view.util.ToastUtil;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/**
 * <微信支付的回调页>
 *
 * @author 王乾州
 * @createon 2016-8-13
 */
public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {
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

    @Override
    public void onResp(BaseResp resp) {
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                // 跳转到支付成功界面
                Bundle bundle = new Bundle();
                bundle.putString("orderCode", CacheSession.getInstance().orderCode);
//                MyFrameCoreTools.getInstance().startActivity(mContext, PaySuccessActivity.class, bundle);
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                ToastUtil.instance.showToast(mContext, "支付取消");
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                ToastUtil.instance.showToast(mContext, "支付失败");
                break;
            default:
                ToastUtil.instance.showToast(mContext, "支付失败");
                break;
        }
        finish();

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