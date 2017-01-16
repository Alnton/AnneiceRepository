package com.alnton.myframe.util;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.alnton.myframe.R;

/**
 * 倒计时工具类
 * @author 王乾州
 */
public class TimeCountCode extends CountDownTimer
{
    private TextView checkingTextView;
    
    private boolean isStart = true;
    
    /**
     * 结算到银行卡 需要独立设置控件文字
     */
    private String activityFlag;
    
    public TimeCountCode(long millisInFuture, long countDownInterval)
    {
        super(millisInFuture, countDownInterval);
    }
    
    /**
     * <设置控件容器>
     */
    public void setContain(TextView checkingTextView, String activityFlag)
    {
        this.checkingTextView = checkingTextView;
        this.activityFlag = activityFlag;
    }
    
    @SuppressLint("ResourceAsColor")
    @Override
    public void onFinish()
    {
        //计时完毕时触发
        this.isStart = true;
        checkingTextView.setTextColor(R.color.typeface_five);
        checkingTextView.setText("重新获取");
        checkingTextView.setClickable(true);
        checkingTextView.setBackgroundResource(R.drawable.button_code);
    }
    
    @Override
    public void onTick(long millisUntilFinished)
    {
        //计时过程显示
        checkingTextView.setClickable(false);
        if (null == activityFlag)
        {
            checkingTextView.setText("重新获取(" + millisUntilFinished / 1000 + "s)");
        }
        else if ("SettleToBankActivity".equals(activityFlag))
        {
            checkingTextView.setText(millisUntilFinished / 1000 + "s");
        }
        
        if (this.isStart)
        {
            checkingTextView.setBackgroundResource(R.drawable.button_code02);
            checkingTextView.setTextColor(Color.WHITE);
        }
        this.isStart = false;
    }
}