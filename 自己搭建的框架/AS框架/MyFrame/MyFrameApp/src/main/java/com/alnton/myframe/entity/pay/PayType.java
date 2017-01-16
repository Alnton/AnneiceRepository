package com.alnton.myframe.entity.pay;

import android.os.Parcel;
import android.os.Parcelable;

import com.alnton.myframecore.okhttp.callback.ResponseEntity;

/**
 * 支付类型实体类
 *
 * @author 王乾州
 * @createon 2016-8-19
 */
public class PayType implements Parcelable {
    /**
     * 类别key
     * wechat 标志着是微信支付
     */
    private String categoryKey;

    /**
     * 类别名称
     */
    private String categoryName;

    public String getCategoryKey() {

        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {

        this.categoryKey = categoryKey;
    }

    public String getCategoryName() {

        return categoryName;
    }

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.categoryKey);
        dest.writeString(this.categoryName);
    }

    public PayType() {
    }

    protected PayType(Parcel in) {
        this.categoryKey = in.readString();
        this.categoryName = in.readString();
    }

    public static final Creator<PayType> CREATOR = new Creator<PayType>() {
        @Override
        public PayType createFromParcel(Parcel source) {
            return new PayType(source);
        }

        @Override
        public PayType[] newArray(int size) {
            return new PayType[size];
        }
    };
}