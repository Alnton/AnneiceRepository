package com.alnton.myframe.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <版本实体类>
 *
 * @author 王乾州
 */
public class UpdateVersion implements Parcelable {
    /**
     * 最新版本号
     * 这个对应的是versionName
     */
    private String verCode;

    /**
     * 最新版本下载url
     */
    private String downUrl;

    /**
     * 最新版本描述
     */
    private String verDesc;

    /**
     * 是否强制更新
     * 0: 强制更新
     * 1: 不强制更新
     */
    public String downType;

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getVerDesc() {
        return verDesc;
    }

    public void setVerDesc(String verDesc) {
        this.verDesc = verDesc;
    }

    public String getDownType() {
        return downType;
    }

    public void setDownType(String downType) {
        this.downType = downType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.verCode);
        dest.writeString(this.downUrl);
        dest.writeString(this.verDesc);
        dest.writeString(this.downType);
    }

    public UpdateVersion() {
    }

    protected UpdateVersion(Parcel in) {
        this.verCode = in.readString();
        this.downUrl = in.readString();
        this.verDesc = in.readString();
        this.downType = in.readString();
    }

    public static final Parcelable.Creator<UpdateVersion> CREATOR = new Parcelable.Creator<UpdateVersion>() {
        @Override
        public UpdateVersion createFromParcel(Parcel source) {
            return new UpdateVersion(source);
        }

        @Override
        public UpdateVersion[] newArray(int size) {
            return new UpdateVersion[size];
        }
    };
}