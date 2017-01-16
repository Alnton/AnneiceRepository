package com.alnton.myframe.ui.main.homePage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alnton.myframe.R;
import com.alnton.myframe.config.FusionCode;
import com.alnton.myframe.fragment.BaseFragment;
import com.alnton.myframe.ui.main.MainActivity;
import com.alnton.myframecore.util.MyFrameCoreTools;
import com.alnton.myframecore.view.zxing.android.CaptureActivity;

/**
 * 主界面中的首页对应的Fragment
 *
 * @author 王乾州
 * @createon 2016-7-27
 */
public class HomepageFragment extends BaseFragment implements OnClickListener {
    /**
     * 父类
     */
    private MainActivity mainActivity;

    /**
     * 根view
     */
    private View parentView;

    /**
     * 扫一扫，消息
     */
    private LinearLayout scanLayout, messageLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_homepage, container, false);

        /**
         * 初始化View
         */
        initView(parentView);

        /**
         * 设置事件监听
         */
        setListener();

        return parentView;
    }

    /**
     * 初始化View
     *
     * @param view
     */
    private void initView(View view) {
        mainActivity = (MainActivity) getActivity();

        scanLayout = (LinearLayout) view.findViewById(R.id.scanLayout);
        messageLayout = (LinearLayout) view.findViewById(R.id.messageLayout);
    }

    /**
     * <设置各个控件的监听>
     */
    private void setListener() {
        scanLayout.setOnClickListener(this);
        messageLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scanLayout:
                /**
                 * 扫一扫
                 */
                MyFrameCoreTools.getInstance().startActivityForResult(mainActivity,
                        CaptureActivity.class,
                        null,
                        FusionCode.REQUEST_CODE_SCAN);
                break;

            default:
                break;
        }
    }
}