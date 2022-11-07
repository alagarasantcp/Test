package com.example.test.responsse;

import com.google.gson.annotations.SerializedName;

public class ServerMsg {
    public ServerMsg(String displayMsg, String msg) {
        this.msg = msg;
        this.displayMsg = displayMsg;
    }

    @SerializedName("Msg") public String msg;
    @SerializedName("DisplayMsg") public String displayMsg;
    @SerializedName("ExMsg") public String exMsg;
}