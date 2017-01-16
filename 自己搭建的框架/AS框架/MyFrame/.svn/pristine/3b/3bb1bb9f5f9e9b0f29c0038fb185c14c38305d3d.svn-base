package com.alnton.myframecore.okhttp.callback;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <接口返回的统一报文>
 * 这个就要求所有的接口返回报文 除了 公共的 count code desc 其他和业务相关的key必须是msg
 *
 * @author 王乾州
 * @createon 2016-8-8
 */
public class ResponseEntity<T> implements Parcelable {

    /**
     * 泛型value
     */
    private T msg;
    /**
     * 返回条目数
     */
    private String count;

    /**
     * 返回状态码
     */
    private String code;

    /**
     * 返回的描述信息
     */
    private String desc;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.count);
        dest.writeString(this.code);
        dest.writeString(this.desc);
    }

    public ResponseEntity() {
    }

    protected ResponseEntity(Parcel in) {
        this.count = in.readString();
        this.code = in.readString();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<ResponseEntity> CREATOR = new Parcelable.Creator<ResponseEntity>() {
        @Override
        public ResponseEntity createFromParcel(Parcel source) {
            return new ResponseEntity(source);
        }

        @Override
        public ResponseEntity[] newArray(int size) {
            return new ResponseEntity[size];
        }
    };
}