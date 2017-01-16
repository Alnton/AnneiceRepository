package com.alnton.myframe.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <城市实体类>
 * 同一个地点 比如南京市（或者 鼓楼区） 它的 `city_key`, `city_id`, `city_code`是一样的
 * 规则：sub_city_code = -1 表示是省 也就是顶级  用市的sub_city_code跟省的city_code比较 一直说明这个市隶属于这个省 反之不是
 * 用区县的sub_city_code跟城市的city_code比较 一直说明这个区县隶属于这个城市 反之不是
 *
 * @author 王乾州
 */
public class City implements Parcelable {
    /**
     * 省份/城市/区县 名称
     */
    private String cityName;

    /**
     * 省份/城市/区县 key
     */
    private String cityKey;

    /**
     * 省份/城市/区县 id
     */
    private String cityId;

    /**
     * 省份/城市/区县 code
     */
    private String cityCode;

    /**
     * 对应子市 区县 code
     */
    private String sub_city_code;

    /**
     *
     */
    private String area_code;

    /**
     *
     */
    private String postalcode;

    /**
     * 状态
     */
    private int status;

    /**
     * 1: 不是最后一级
     * 0：是最后一级
     */
    private int end_flag;

    /**
     * 是否选择
     * 0：未选择
     * 1：已选择
     */
    private int isCheck;

    public String getCityName() {

        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getSub_city_code() {
        return sub_city_code;
    }

    public void setSub_city_code(String sub_city_code) {
        this.sub_city_code = sub_city_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEnd_flag() {
        return end_flag;
    }

    public void setEnd_flag(int end_flag) {
        this.end_flag = end_flag;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cityName);
        dest.writeString(this.cityKey);
        dest.writeString(this.cityId);
        dest.writeString(this.cityCode);
        dest.writeString(this.sub_city_code);
        dest.writeString(this.area_code);
        dest.writeString(this.postalcode);
        dest.writeInt(this.status);
        dest.writeInt(this.end_flag);
        dest.writeInt(this.isCheck);
    }

    public City() {
    }

    protected City(Parcel in) {
        this.cityName = in.readString();
        this.cityKey = in.readString();
        this.cityId = in.readString();
        this.cityCode = in.readString();
        this.sub_city_code = in.readString();
        this.area_code = in.readString();
        this.postalcode = in.readString();
        this.status = in.readInt();
        this.end_flag = in.readInt();
        this.isCheck = in.readInt();
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}