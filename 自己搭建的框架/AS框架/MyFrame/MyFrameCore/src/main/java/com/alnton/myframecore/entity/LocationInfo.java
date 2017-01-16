package com.alnton.myframecore.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <地理位置实体类>
 *
 * @author 王乾州
 */
public class LocationInfo implements Parcelable {
    /**
     * 定位类型
     */
    private int locationType;

    /**
     * 经度
     */
    private double longitude;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 精度
     */
    private float accuracy;

    /**
     * 定位方式
     * LBS --- 网络
     * GPS --- 卫星
     */
    private String provider;

    /**
     * 速度 米/秒
     */
    private float speed;

    /**
     * 角度
     */
    private float bearing;

    /**
     * 星数
     */
    private int satellites;

    /**
     * 定位时间  耗时  单位：毫秒
     */
    private long time;

    /**
     * 国家
     */
    private String country;

    /**
     * 城市编号
     */
    private String cityCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 兴趣点
     */
    private String poiName;

    /**
     * 区(县)
     */
    private String district;

    /**
     * 区域编码
     */
    private String adCode;

    /**
     * 错误码
     */
    private int errorCode;

    /**
     * 错误信息
     */
    private String errorInfo;

    /**
     * 错误描述
     */
    private String errorLocationDetail;

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    public int getSatellites() {
        return satellites;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getErrorLocationDetail() {
        return errorLocationDetail;
    }

    public void setErrorLocationDetail(String errorLocationDetail) {
        this.errorLocationDetail = errorLocationDetail;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.locationType);
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.latitude);
        dest.writeFloat(this.accuracy);
        dest.writeString(this.provider);
        dest.writeFloat(this.speed);
        dest.writeFloat(this.bearing);
        dest.writeInt(this.satellites);
        dest.writeLong(this.time);
        dest.writeString(this.country);
        dest.writeString(this.cityCode);
        dest.writeString(this.address);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.poiName);
        dest.writeString(this.district);
        dest.writeString(this.adCode);
        dest.writeInt(this.errorCode);
        dest.writeString(this.errorInfo);
        dest.writeString(this.errorLocationDetail);
    }

    public LocationInfo() {
    }

    protected LocationInfo(Parcel in) {
        this.locationType = in.readInt();
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.accuracy = in.readFloat();
        this.provider = in.readString();
        this.speed = in.readFloat();
        this.bearing = in.readFloat();
        this.satellites = in.readInt();
        this.time = in.readLong();
        this.country = in.readString();
        this.cityCode = in.readString();
        this.address = in.readString();
        this.province = in.readString();
        this.city = in.readString();
        this.poiName = in.readString();
        this.district = in.readString();
        this.adCode = in.readString();
        this.errorCode = in.readInt();
        this.errorInfo = in.readString();
        this.errorLocationDetail = in.readString();
    }

    public static final Parcelable.Creator<LocationInfo> CREATOR = new Parcelable.Creator<LocationInfo>() {
        @Override
        public LocationInfo createFromParcel(Parcel source) {
            return new LocationInfo(source);
        }

        @Override
        public LocationInfo[] newArray(int size) {
            return new LocationInfo[size];
        }
    };
}