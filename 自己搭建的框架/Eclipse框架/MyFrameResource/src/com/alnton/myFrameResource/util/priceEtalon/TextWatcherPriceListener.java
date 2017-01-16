package com.alnton.myFrameResource.util.priceEtalon;

import android.text.Editable;
import android.view.View;

public interface TextWatcherPriceListener {

	public void onTextChanged(CharSequence s, int start, int before, int count);
	public void beforeTextChanged(CharSequence s, int start, int count, int after);
	public void afterTextChanged(Editable s);
	/**
	 * @Description: 焦点的监听 
	 * @param v
	 * @param hasFocus
	 */
	public void onFocusChange(View v, boolean hasFocus);
}
