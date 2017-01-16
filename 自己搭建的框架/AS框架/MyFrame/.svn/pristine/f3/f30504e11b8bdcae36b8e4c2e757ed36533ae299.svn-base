package com.alnton.myframe.ui.picture;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;

import com.alnton.myframe.R;
import com.alnton.myframe.ui.BaseActivity;
import com.alnton.myframecore.util.ImageUtil;

/**
 * <静态图片组中的某张图片>
 *
 * @author 王乾州
 */
public class PictureActivity extends BaseActivity {
    private LinearLayout ll_viewArea;

    private LinearLayout.LayoutParams parm;

    private ViewArea viewArea;

    private Bitmap bitmap;

    private String address;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_one);

        /**
         * 初始化View
         */
        initView();

        /**
         * 获取上个界面的图片地址
         */
        getBundler();
    }

    private void getBundler() {
        address = getIntent().getStringExtra("address");
        bitmap = getIntent().getParcelableExtra("bitmap");

        if (!TextUtils.isEmpty(address)) {
            /**
             * 加载网络图片
             */
            ImageUtil.getInstance().getBitmap(PictureActivity.this, address, new ImageUtil.OnGetBitmapListener() {
                @Override
                public void onGetBitmapReady(Bitmap bitmap) {
                    if (bitmap != null) {
                        /**
                         * 自定义布局控件，用来初始化并存放自定义imageView
                         */
                        ll_viewArea.removeAllViews();
                        viewArea = new ViewArea(PictureActivity.this, bitmap);
                        ll_viewArea.addView(viewArea, parm);
                    } else {
                        ImageUtil.getInstance().getBitmap(PictureActivity.this, "drawable://" + R.mipmap.default_pic, new ImageUtil.OnGetBitmapListener() {
                            @Override
                            public void onGetBitmapReady(Bitmap bitmap) {
                                if (bitmap != null) {
                                    /**
                                     * 自定义布局控件，用来初始化并存放自定义imageView
                                     */
                                    ll_viewArea.removeAllViews();
                                    viewArea = new ViewArea(PictureActivity.this, bitmap);
                                    ll_viewArea.addView(viewArea, parm);
                                }
                            }
                        });
                    }
                }
            });
        } else {
            if (null == bitmap) {
                ImageUtil.getInstance().getBitmap(PictureActivity.this, "drawable://" + R.mipmap.default_pic, new ImageUtil.OnGetBitmapListener() {
                    @Override
                    public void onGetBitmapReady(Bitmap bitmap) {
                        /**
                         * 自定义布局控件，用来初始化并存放自定义imageView
                         */
                        viewArea = new ViewArea(mContext, bitmap);
                        ll_viewArea.addView(viewArea, parm);
                    }
                });
            } else if (null != bitmap) {
                /**
                 * 自定义布局控件，用来初始化并存放自定义imageView
                 */
                viewArea = new ViewArea(mContext, bitmap);
                ll_viewArea.addView(viewArea, parm);
            }
        }
    }

    private void initView() {
        ll_viewArea = (LinearLayout) findViewById(R.id.ll_viewArea);
        parm =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
    }

}