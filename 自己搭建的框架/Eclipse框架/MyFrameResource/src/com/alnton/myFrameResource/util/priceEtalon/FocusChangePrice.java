package com.alnton.myFrameResource.util.priceEtalon;

import java.text.DecimalFormat;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

/**
 * <价格焦点改变事件监听>
 * @author  詹海
 * @createon 2016-9-26
 */
class FocusChangePrice implements OnFocusChangeListener
{
    /**
     * 输入价格的编辑框
     */
    private EditText priceEt;
    
    /**
     * 小数点转换
     */
    private DecimalFormat decimalFormat;
    
    /**
     * 对外的监听
     */
    private TextWatcherPriceListener textWatcherPriceListener;
    
    public FocusChangePrice(EditText priceEt, int decimalBackMaxLength,TextWatcherPriceListener textWatcherPriceListener)
    {
        StringBuffer buffer = new StringBuffer("######0.");
        for (int i = 0; i < decimalBackMaxLength; i++)
        {//小数点后面的长度，跟规则同步
            buffer.append("0");
        }
        this.decimalFormat = new DecimalFormat(buffer.toString());
        this.priceEt = priceEt;
        this.textWatcherPriceListener = textWatcherPriceListener;
    }
    
    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        if (!hasFocus)
        {// 此处为失去焦点时的处理内容
            String oldPrice = this.priceEt.getText().toString().trim();
            if (!TextUtils.isEmpty(oldPrice))
            {
                //转换
                String newPrice = decimalFormat.format(Double.parseDouble(oldPrice));
                priceEt.setText(newPrice);
            }
        }
        
        if(null!=textWatcherPriceListener){
        	textWatcherPriceListener.onFocusChange(priceEt, hasFocus);
        }
    }
}