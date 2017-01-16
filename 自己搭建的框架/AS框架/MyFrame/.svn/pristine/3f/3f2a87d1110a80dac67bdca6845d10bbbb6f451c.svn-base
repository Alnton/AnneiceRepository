package com.alnton.myframe.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alnton.myframe.R;
import com.alnton.myframe.config.FusionCode;
import com.alnton.myframecore.view.Button.ClickEffectButton;
import com.alnton.myframecore.view.Marquee.MarqueeText;

/**
 * <展示网页的公共类>
 *
 * @author 王乾州
 */
public class UrlActivity extends BaseActivity implements OnClickListener {
    /**
     * 展示网页的控件
     */
    private WebView webView;

    /**
     * 返回按钮
     */
    private ClickEffectButton backButton;

    /**
     * 标题
     */
    private MarqueeText titleTextView;

    /**
     * 网页地址,标题
     */
    private String url, title;

    /**
     * UrlActivity中自定义标题进度值
     */
    private TextView progressTextView;

    /**
     * 进度值
     */
    private ProgressBar progressBar;

    /**
     * UrlActivity中自定义标题加载进度的广播
     */
    BroadcastReceiver urlProgressReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (FusionCode.instance.HAPPY_URL_RECEIVER.equals(intent.getAction())) {
                int newProgress = intent.getIntExtra("progress", 0);
                /**
                 * 更改自定义的标题显示进度
                 */
                if (null != progressTextView) {
                    progressTextView.setVisibility(View.VISIBLE);
                    progressTextView.setText(newProgress + "%");
                }
                if (null != progressBar) {
                    progressBar.setVisibility(View.VISIBLE);
                }
                if (100 == newProgress) {
                    if (null != progressBar) {
                        progressBar.setVisibility(View.GONE);
                    }

                    if (null != progressTextView) {
                        progressTextView.setVisibility(View.GONE);
                    }
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.url);

        /**
         * 接收上个界面的值
         */
        getBundle();

        /**
         * 初始化View
         */
        initView();

        /**
         * 给各个控件增加监听
         */
        setListener();
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            url = bundle.getString("url");
            title = bundle.getString("title");
        }
    }

    private void initView() {
        /* 注册UrlActivity自定义标题加载进度的广播 */
        this.registerReceiver(urlProgressReceiver, new IntentFilter(FusionCode.instance.HAPPY_URL_RECEIVER));

        backButton = (ClickEffectButton) findViewById(R.id.backButton);
        titleTextView = (MarqueeText) findViewById(R.id.titleTextView);
        titleTextView.setText(title);

        progressTextView = (TextView) this.findViewById(R.id.progressTextView);
        progressBar = (ProgressBar) this.findViewById(R.id.progress);
        webView = (WebView) this.findViewById(R.id.htmlWebView);

        webView.loadUrl(url);
        webView.canGoBack();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);//设置能否调用脚本
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Intent intent = new Intent(FusionCode.instance.HAPPY_URL_RECEIVER);
                intent.putExtra("progress", newProgress);
                sendBroadcast(intent);
                super.onProgressChanged(view, newProgress);
            }

        });

        //使WebView的网页跳转在WebView中进行，而非跳到浏览器
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        });
    }

    private void setListener() {
        backButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        if (null != progressBar) {
            progressBar.setVisibility(View.GONE);
        }

        if (null != progressTextView) {
            progressTextView.setVisibility(View.GONE);
        }
        /**
         * 销毁UrlActivity自定义标题加载进度的广播
         */
        this.unregisterReceiver(urlProgressReceiver);
        super.onDestroy();
    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton:
                finish();
                break;

            default:
                break;
        }
    }
}