package com.alnton.myframe.ui.picture;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 展示图片实体类
 *
 * @author 王乾州
 * @createon 2016-8-30
 */
public class PictureInfo implements Parcelable {
    /**
     * 网络图片地址
     */
    private String picUrl;

    /**
     * 本地图片的Bitmap
     */
    private Bitmap bitmap;

    /**
     * 图片标识(1:LOGO,2:首页,3:直通车)
     */
    private String picFlag;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getPicFlag() {
        return picFlag;
    }

    public void setPicFlag(String picFlag) {
        this.picFlag = picFlag;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.picUrl);
        dest.writeParcelable(this.bitmap, flags);
        dest.writeString(this.picFlag);
    }

    public PictureInfo() {
    }

    protected PictureInfo(Parcel in) {
        this.picUrl = in.readString();
        this.bitmap = in.readParcelable(Bitmap.class.getClassLoader());
        this.picFlag = in.readString();
    }

    public static final Parcelable.Creator<PictureInfo> CREATOR = new Parcelable.Creator<PictureInfo>() {
        @Override
        public PictureInfo createFromParcel(Parcel source) {
            return new PictureInfo(source);
        }

        @Override
        public PictureInfo[] newArray(int size) {
            return new PictureInfo[size];
        }
    };
}