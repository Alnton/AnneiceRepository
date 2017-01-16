package com.alnton.myframe.entity.user;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 用户信息
 *
 * @Author 詹海
 * @Date 2016-8-13 上午10:28:45
 * @Version V1.0
 */
public class UserInfo implements Parcelable {
    /**
     * 登录成功的key，登录账号,用户密码,第三方唯一标志,账户类型(0:正式, 1:临时),tokenId，极光推送的别名
     */
    private String accountKey, userName, passWord, applyKey, accountType, tokenId, accountId;

    /**
     * 商铺状态(-1:草稿,0:生效, 1:审核中, 2:冻结)
     */
    private String status;

    /**
     * 用户昵称,用户头像,商铺名,商铺图标
     */
    private String petName, headPic, shopName, shopIcon;

    /**
     * 用户实名标识(0:已认证, 1:未认证)
     */
    private String authFlag = "-1";

    /**
     * 商铺实名标识(0:已认证, 1:未认证)
     */
    private String sAuthFlag;

    private String bindTel;

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getApplyKey() {
        return applyKey;
    }

    public void setApplyKey(String applyKey) {
        this.applyKey = applyKey;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopIcon() {
        return shopIcon;
    }

    public void setShopIcon(String shopIcon) {
        this.shopIcon = shopIcon;
    }

    public String getAuthFlag() {
        return authFlag;
    }

    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }

    public String getsAuthFlag() {
        return sAuthFlag;
    }

    public void setsAuthFlag(String sAuthFlag) {
        this.sAuthFlag = sAuthFlag;
    }

    public String getBindTel() {
        return bindTel;
    }

    public void setBindTel(String bindTel) {
        this.bindTel = bindTel;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accountKey);
        dest.writeString(this.userName);
        dest.writeString(this.passWord);
        dest.writeString(this.applyKey);
        dest.writeString(this.accountType);
        dest.writeString(this.tokenId);
        dest.writeString(this.accountId);
        dest.writeString(this.status);
        dest.writeString(this.petName);
        dest.writeString(this.headPic);
        dest.writeString(this.shopName);
        dest.writeString(this.shopIcon);
        dest.writeString(this.authFlag);
        dest.writeString(this.sAuthFlag);
        dest.writeString(this.bindTel);
    }

    public UserInfo() {
    }

    protected UserInfo(Parcel in) {
        this.accountKey = in.readString();
        this.userName = in.readString();
        this.passWord = in.readString();
        this.applyKey = in.readString();
        this.accountType = in.readString();
        this.tokenId = in.readString();
        this.accountId = in.readString();
        this.status = in.readString();
        this.petName = in.readString();
        this.headPic = in.readString();
        this.shopName = in.readString();
        this.shopIcon = in.readString();
        this.authFlag = in.readString();
        this.sAuthFlag = in.readString();
        this.bindTel = in.readString();
    }

    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}