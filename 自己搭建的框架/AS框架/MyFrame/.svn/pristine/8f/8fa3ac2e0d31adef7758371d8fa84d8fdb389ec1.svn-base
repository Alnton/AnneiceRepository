package com.alnton.myframecore.view.util.priceEtalon;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

import java.text.DecimalFormat;

/**
 * <价格焦点改变事件监听>
 *
 * @author 詹海
 * @createon 2016-9-26
 */
class FocusChangePrice implements OnFocusChangeListener {
    /**
     * 输入价格的编辑框
     */
    private EditText priceEt;

    /**
     * 小数点转换
     */
    private DecimalFormat decimalFormat;

    public FocusChangePrice(EditText priceEt, int decimalBackMaxLength) {
        StringBuffer buffer = new StringBuffer("######0.");
        for (int i = 0; i < decimalBackMaxLength; i++) {//小数点后面的长度，跟规则同步
            buffer.append("0");
        }
        this.decimalFormat = new DecimalFormat(buffer.toString());
        this.priceEt = priceEt;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {// 此处为失去焦点时的处理内容
            String oldPrice = this.priceEt.getText().toString().trim();
            if (!TextUtils.isEmpty(oldPrice)) {
                //转换
                String newPrice = decimalFormat.format(Double.parseDouble(oldPrice));
                priceEt.setText(newPrice);
            }
        }
    }
}