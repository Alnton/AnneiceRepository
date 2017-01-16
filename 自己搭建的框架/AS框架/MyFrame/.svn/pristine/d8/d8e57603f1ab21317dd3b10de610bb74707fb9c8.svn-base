package com.alnton.myframe.util;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.alnton.myframe.config.Config;
import com.alnton.myframecore.util.SharedPreferencesUtil;

/**
 * <本地验证码工具类>
 *
 * @author 詹海
 * @createon 2016-9-21
 */
public class GraphCodeUitl {
    /**
     * 第几次点击了获取验证码
     **/
    int graphCodeNum = 1;

    /**
     * 显示图形验证码的大布局
     */
    View graphCodeView;

    /**
     * 显示图形验证码的图片
     */
    ImageView graph_code_iv;

    SharedPreferencesUtil sharedPreferencesUtil;

    String account;

    EditText account_et;

    public boolean isShow = false;

    public GraphCodeUitl(View graphCodeView, ImageView graph_code_iv, EditText account,
                         SharedPreferencesUtil sharedPreferencesUtil) {
        this.graphCodeView = graphCodeView;
        this.graph_code_iv = graph_code_iv;
        this.sharedPreferencesUtil = sharedPreferencesUtil;
        this.account_et = account;
        GraphCode.getInstance().code = null;

        GraphCodeUitl.this.graph_code_iv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                GraphCodeUitl.this.graph_code_iv.setImageBitmap(GraphCode.getInstance().createBitmap());
            }
        });

        this.account_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 11) {
                    showGraphCodeView();
                }
            }
        });
    }

    /**
     * @param
     * @return void
     * @throws
     * @Description 显示图形验证码
     */
    @SuppressLint("NewApi")
    public void showGraphCodeView() {
        this.account = this.account_et.getText().toString();
        this.graphCodeNum = this.sharedPreferencesUtil.getInt(this.account, 1);
        if (this.graphCodeNum > Config.SharedPreferencesConfig.GRAPHCODE_SHOW_NUM) {
            if (GraphCode.getInstance().code == null || GraphCode.getInstance().code.isEmpty()) {
                this.graph_code_iv.setImageBitmap(GraphCode.getInstance().createBitmap());
            }
            this.graphCodeView.setVisibility(View.VISIBLE);
            this.isShow = true;
        } else {
            GraphCode.getInstance().code = null;
            this.graph_code_iv.setImageBitmap(null);
            this.graphCodeView.setVisibility(View.GONE);
            this.isShow = false;
        }
    }

    public void addNum() {
        this.sharedPreferencesUtil.put(this.account, ++this.graphCodeNum);
        this.sharedPreferencesUtil.commit();
    }

    public void removeNum() {
        this.sharedPreferencesUtil.remove(this.account);
    }
}