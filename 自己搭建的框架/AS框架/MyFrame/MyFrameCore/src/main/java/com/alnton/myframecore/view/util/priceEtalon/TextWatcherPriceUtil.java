package com.alnton.myframecore.view.util.priceEtalon;

import android.content.Context;
import android.widget.EditText;

/**
 * <价格输入框校验工具类>
 *
 * @author 詹海
 * @createon 2016-9-26
 */
public enum TextWatcherPriceUtil {

    instance;

    TextWatcherPriceUtil() {

    }

    /**
     * 设置价格的输入规则 （没有焦点事件）
     *
     * @param context 上下文
     * @param arrayId 价格规则的ID
     * @param priceEt 编辑框集合
     */
    public void addTextWatcherPrice(Context context, int arrayId, EditText... priceEt) {
        //价格规则
        String[] stringArray = context.getResources().getStringArray(arrayId);
        if (null != stringArray && stringArray.length == 2) {
            //小点数前面最大长度
            int decimalFrontMaxLength = Integer.parseInt(stringArray[0]);
            //小点数后面最大长度
            int decimalBackMaxLength = Integer.parseInt(stringArray[1]);
            for (EditText editText : priceEt) {//设置输入的监听
                editText.addTextChangedListener(new TextWatcherPrice(editText, decimalFrontMaxLength,
                        decimalBackMaxLength));
            }
        }
    }

    /**
     * 设置价格的输入规则 （焦点事件,当输入框离开焦点时，（输入的是 0. = 0.00，小数点后面的零，跟小数点后面的最大长度同步））
     *
     * @param context 上下文
     * @param arrayId 价格规则的ID
     * @param priceEt 编辑框集合
     */
    public void addTextWatcherFocusChangePrice(Context context, int arrayId, EditText... priceEt) {
        //价格规则
        String[] stringArray = context.getResources().getStringArray(arrayId);
        if (null != stringArray && stringArray.length == 2) {
            //小点数前面最大长度
            int decimalFrontMaxLength = Integer.parseInt(stringArray[0]);
            //小点数后面最大长度
            int decimalBackMaxLength = Integer.parseInt(stringArray[1]);
            for (EditText editText : priceEt) {
                //设置输入的监听
                editText.addTextChangedListener(new TextWatcherPrice(editText, decimalFrontMaxLength,
                        decimalBackMaxLength));
                //设置焦点的监听
                editText.setOnFocusChangeListener(new FocusChangePrice(editText, decimalBackMaxLength));
            }
        }
    }
}