package com.example.test.responsse;

import com.google.gson.annotations.SerializedName;

public class Customers {
    @SerializedName("MobileNo") public String mobileNo;
    @SerializedName("EmailID") public String emailID;
    @SerializedName("ShopSK") public String shopSK;
    @SerializedName("ShopName") public String shopName;
    @SerializedName("CustomerSK") public String customerSK;
    @SerializedName("Address") public String address;
    @SerializedName("countryCode") public String countryCode;
    @SerializedName("Logo") public String logo;
    //  The below three fields are for Forgot password fields
    @SerializedName("ProfileImage") public String profileImage;
    @SerializedName("CustomerName") public String customerName;
    @SerializedName("AllowSMS") public String allowSMS;
}