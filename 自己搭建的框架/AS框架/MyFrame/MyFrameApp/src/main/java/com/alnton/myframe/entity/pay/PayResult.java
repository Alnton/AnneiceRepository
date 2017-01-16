package com.alnton.myframe.entity.pay;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 支付结果实体类
 *
 * @author 王乾州
 * @createon 2016-8-19
 */
public class PayResult implements Parcelable {

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 收货人姓名
     */
    private String userName;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 订单金额
     */
    private String orderMoney;

    /**
     * 支付方式（1银联2支付宝 3微信）
     */
    private String payType;

    public String getOrderCode() {

        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getOrderMoney() {

        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {

        this.orderMoney = orderMoney;
    }

    public String getPayType() {

        return payType;
    }

    public void setPayType(String payType) {

        this.payType = payType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.orderCode);
        dest.writeString(this.userName);
        dest.writeString(this.telephone);
        dest.writeString(this.address);
        dest.writeString(this.orderMoney);
        dest.writeString(this.payType);
    }

    public PayResult() {
    }

    protected PayResult(Parcel in) {
        this.orderCode = in.readString();
        this.userName = in.readString();
        this.telephone = in.readString();
        this.address = in.readString();
        this.orderMoney = in.readString();
        this.payType = in.readString();
    }

    public static final Parcelable.Creator<PayResult> CREATOR = new Parcelable.Creator<PayResult>() {
        @Override
        public PayResult createFromParcel(Parcel source) {
            return new PayResult(source);
        }

        @Override
        public PayResult[] newArray(int size) {
            return new PayResult[size];
        }
    };
}