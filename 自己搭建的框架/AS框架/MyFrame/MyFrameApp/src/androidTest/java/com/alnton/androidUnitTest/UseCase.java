package com.alnton.androidUnitTest;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.alnton.myframe.application.Session;
import com.alnton.myframe.ui.picture.PictureInfo;
import com.alnton.myframecore.okhttp.OKHttpUtil;
import com.alnton.myframecore.okhttp.callback.ResponseEntity;
import com.alnton.myframecore.okhttp.callback.ResultCallback;
import com.alnton.myframecore.util.DebugLogUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

/**
 * OKHttp3  使用案例
 * 作者：${王乾州} on 2016/10/27 16:00
 */
@RunWith(AndroidJUnit4.class)
public class UseCase {

    static {
        OKHttpUtil.instance.init(Session.getInstance().getApplicationContext(), true, null);
        OKHttpUtil.instance.clearAllHeader();
    }

    /**
     * 测试同步get请求 直接获取字符串
     */
    @Test
    public void testOnGetString() {
        Log.e(DebugLogUtil.TAG, "onGetString: " + OKHttpUtil.instance.onGetString("https://www.baidu.com"));
    }

    /**
     * 测试动态设置header信息
     */
    @Test
    public void testSetheader() {
        OKHttpUtil.instance.setHeader("tokenId", "123456789");
        Log.e(DebugLogUtil.TAG, "setHeader: " + OKHttpUtil.instance.onGetString("http://aquaticread.xiao6.com/fzjt_aquatic_read/query/homePic"));
    }

    /**
     * 测试删除指定header信息
     */
    @Test
    public void testDelTheheader() {
        OKHttpUtil.instance.clearTheHeader("tokenId");
        Log.e(DebugLogUtil.TAG, "testDelTheheader: " + OKHttpUtil.instance.onGetString("http://aquaticread.xiao6.com/fzjt_aquatic_read/query/homePic"));
    }

    /**
     * 测试删除所有的header信息
     */
    @Test
    public void testDelAllheader() {
        OKHttpUtil.instance.clearAllHeader();
        Log.e(DebugLogUtil.TAG, "testDelAllheader: " + OKHttpUtil.instance.onGetString("http://aquaticread.xiao6.com/fzjt_aquatic_read/query/homePic"));
    }

    /**
     * 测试异步get请求 有参数 无参数
     */
    @Test
    public void testOnGet() {
        final ResultCallback<ResponseEntity<ArrayList<PictureInfo>>> res = new ResultCallback<ResponseEntity<ArrayList<PictureInfo>>>() {
            @Override
            public void onResponse(ResponseEntity<ArrayList<PictureInfo>> response) {

            }
        };
        // 目的是单元测试 不弹出加载框
        res.setShowProgressDialog(false);
        OKHttpUtil.instance.onGet("http://aquaticread.xiao6.com/fzjt_aquatic_read/query/homePic", null, res);
    }

    /**
     * 测试异步post请求 json
     */
    @Test
    public void testOnPostJson() {
        ResultCallback<ResponseEntity<ArrayList<PictureInfo>>> res = new ResultCallback<ResponseEntity<ArrayList<PictureInfo>>>() {
            @Override
            public void onResponse(ResponseEntity<ArrayList<PictureInfo>> response) {
                Log.e(DebugLogUtil.TAG, "***: " + response.getCode());
            }
        };
        // 目的是单元测试 不弹出加载框
        res.setShowProgressDialog(false);
        OKHttpUtil.instance.onPostJson("http://aquaticread.xiao6.com/fzjt_aquatic_read/query/homePic", "", res);
    }
}
