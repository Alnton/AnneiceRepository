package com.alnton.myframe.ui.welcome;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.alnton.myframe.R;
import com.alnton.myframe.config.Config.URLConfig;
import com.alnton.myframe.ui.BaseActivity;
import com.alnton.myframe.ui.picture.PictureInfo;
import com.alnton.myframecore.application.CacheSession;
import com.alnton.myframecore.okhttp.OKHttpUtil;
import com.alnton.myframecore.okhttp.callback.ResponseEntity;
import com.alnton.myframecore.okhttp.callback.ResultCallback;
import com.alnton.myframecore.util.ImageUtil;
import com.alnton.myframecore.util.MyFrameCoreTools;

import java.util.ArrayList;

import cn.jpush.android.api.JPushInterface;

/**
 * <欢迎界面>
 *
 * @author 王乾州
 */
public class WelcomeActivity extends BaseActivity {
    /**
     * 广告页图片地址
     */
    private String adPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_welcome);

        /**
         * 加载banner 活动直通车 图片
         */
        loadPic();
    }

    /**
     * 加载banner 活动直通车 图片
     */
    private void loadPic() {
        ResultCallback<ResponseEntity<ArrayList<PictureInfo>>> resultCallback = new ResultCallback<ResponseEntity<ArrayList<PictureInfo>>>() {
            @Override
            public void onResponse(ResponseEntity<ArrayList<PictureInfo>> response) {
                ArrayList<PictureInfo> listInfo = response.getMsg();

                if (null != listInfo && listInfo.size() > 0) {
                    for (int i = 0; i < listInfo.size(); i++) {
                        if ("1".equals(listInfo.get(i).getPicFlag())) {
                            adPic = listInfo.get(i).getPicUrl();
                        }
                    }
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                ImageUtil.getInstance().getBitmap(getApplicationContext(), adPic, new ImageUtil.OnGetBitmapListener() {
                    @Override
                    public void onGetBitmapReady(Bitmap bitmap) {
                        CacheSession.getInstance().bitmap = bitmap;
                    }
                });
                /**
                 * 停留1秒，进入广告界面
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        MyFrameCoreTools.getInstance().startActivity(mContext, ADActivity.class, null);
                        finish();
                    }
                }).start();
            }
        };
        resultCallback.setShowProgressDialog(false);
        resultCallback.setShowToast(false);
        resultCallback.setOnErrorShowToast(false);
        OKHttpUtil.instance.onPostParams(URLConfig.HOMEPAGE_PIC_URL, null, resultCallback);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(mContext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(mContext);
    }
}