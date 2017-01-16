package com.alnton.myframecore.okhttp.request;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <接口请求的报文，为了解决换行等特殊字符 服务器转换不了>
 *
 * @author 王乾州
 * @createon 2016-8-8
 */
public class RequestEntity implements Parcelable {
    /**
     * 请求的内容
     */
    private String value;

    public RequestEntity(String value) {

        this.setValue(value);
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
    }

    protected RequestEntity(Parcel in) {
        this.value = in.readString();
    }

    public static final Parcelable.Creator<RequestEntity> CREATOR = new Parcelable.Creator<RequestEntity>() {
        @Override
        public RequestEntity createFromParcel(Parcel source) {
            return new RequestEntity(source);
        }

        @Override
        public RequestEntity[] newArray(int size) {
            return new RequestEntity[size];
        }
    };
}