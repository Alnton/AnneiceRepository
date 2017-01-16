package com.alnton.myframe.util;

import android.text.TextUtils;
import android.widget.TextView;

/**
 * <TextView 设置工具类>
 *
 * @author 王乾州
 */
public class ViewUtil {
    public static void setTextView(final TextView txtView, final String val, String defVal) {
        if (null != txtView) {
            if (TextUtils.isEmpty(val) || "null".equalsIgnoreCase(val) || "(null)".equals(val.trim())) {
                txtView.setText(defVal);
            } else {
                txtView.setText(val);
            }
        }
    }
}