package com.example.test.request;

import com.google.gson.annotations.SerializedName;

public class ReqLogin {
    @SerializedName("UserName") public String userName;
    @SerializedName("CustomerSK") public int customerSK;
    @SerializedName("DeviceData") public DeviceData deviceData;
    @SerializedName("ParentShopSK") public String parentShopSK;
    @SerializedName("Password") public String password;
    @SerializedName("SkipLogin") public String skipLogin;

    public ReqLogin(String userName, DeviceData deviceData, String parentShopSK, String password, String skipLogin) {
        this.userName = userName;
        this.deviceData = deviceData;
        this.parentShopSK = parentShopSK;
        this.password = password;
        this.skipLogin = skipLogin;
    }

    public ReqLogin(DeviceData deviceData, String parentShopSK, String skipLogin) {
        this.deviceData = deviceData;
        this.parentShopSK = parentShopSK;
        this.skipLogin = skipLogin;
    }

    public static class DeviceData {
        @SerializedName("DeviceID") public String deviceID;
        @SerializedName("DeviceType") public String deviceType;
        @SerializedName("IsActive") public String isActive;
        @SerializedName("NeedLangaugeLabel") public String needLangaugeLabel = "Y";

        public DeviceData(String deviceType, String deviceID, String isActive) {
            this.deviceType = deviceType;
            this.deviceID = deviceID;
            this.isActive = isActive;
        }
    }

}