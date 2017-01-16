package com.alnton.myframecore.view.util.priceEtalon;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * <价格输入事件监听>
 *
 * @author 詹海
 * @createon 2016-10-21
 */
class TextWatcherPrice implements TextWatcher {

    /**
     * 小点数前面最大长度
     */
    private int decimalFrontMaxLength;

    /**
     * 小点数后面最大长度
     */
    private int decimalBackMaxLength;

    /**
     * 输入价格的编辑框
     */
    private EditText priceEt;

    /**
     * 拼接字符
     */
    private StringBuffer stringBuffer;

    public TextWatcherPrice(EditText priceEt, int decimalFrontMaxLength, int decimalBackMaxLength) {
        this.priceEt = priceEt;
        this.decimalFrontMaxLength = decimalFrontMaxLength;
        this.decimalBackMaxLength = decimalBackMaxLength;
        this.stringBuffer = new StringBuffer();

        //设置最大输入长度
        int maxLength = decimalFrontMaxLength + decimalBackMaxLength + 1;
        priceEt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //清空保存的字符
        this.stringBuffer.setLength(0);

        //输入的字符达到小数点前最大值时，再输入自动加上小数点
        if (s.toString().length() > decimalFrontMaxLength && !s.toString().contains(".")) {
            String rawData = s.toString();
            //得到小数点前面的字符
            String pointFront = rawData.subSequence(0, decimalFrontMaxLength).toString();
            this.stringBuffer.append(pointFront);
            //得到小数点后面的字符
            String pointBack = rawData.subSequence(decimalFrontMaxLength, rawData.length()).toString();
            //添加小数点和小数点后面的字符
            this.stringBuffer.append(".").append(pointBack);

            this.priceEt.setText(this.stringBuffer.toString());
            //设置光标在最后
            this.priceEt.setSelection(this.priceEt.getText().length());
        }//以小数点开头，小数点前面自动添加0 ( . = 0. )
        else if (s.toString().trim().length() == 1 && s.toString().trim().startsWith(".")) {
            this.stringBuffer.append("0").append(s);
            this.priceEt.setText(this.stringBuffer.toString());
            this.priceEt.setSelection(this.priceEt.getText().length());
        }//小数点前、后的最大长度
        else if (s.toString().contains(".")) {//是否包含小数点
            //小数点的前面有几位数
            if (s.toString().indexOf(".") > decimalFrontMaxLength) {
                String rawData = s.toString();
                this.stringBuffer.append(rawData);
                this.stringBuffer.replace(start, start + 1, "");
                this.priceEt.setText(this.stringBuffer.toString());
                //设置光标在最后
                this.priceEt.setSelection(this.priceEt.getText().length());
            }
            //小数点的后面有几位数
            if (s.length() - 1 - s.toString().indexOf(".") > decimalBackMaxLength) {
                //截取赋值
                s = s.toString().subSequence(0,
                        s.toString().indexOf(".") + (decimalBackMaxLength + 1));
                this.priceEt.setText(s);
                this.priceEt.setSelection(this.priceEt.getText().length());
            }
        }//第一个字符为0,再输入字符时，自动加上小数点
        else if (s.toString().startsWith("0") && s.toString().length() > 1) {
            String rawData = s.toString();
            this.stringBuffer.append("0");
            //得到小数点后面的字符
            String pointBack = rawData.subSequence(1, rawData.length()).toString();
            //添加小数点和小数点后面的字符
            this.stringBuffer.append(".").append(pointBack);

            this.priceEt.setText(this.stringBuffer.toString());
            //设置光标在最后
            this.priceEt.setSelection(this.priceEt.getText().length());
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}
