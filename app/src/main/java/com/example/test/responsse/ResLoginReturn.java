package com.example.test.responsse;

import com.google.gson.annotations.SerializedName;

public class ResLoginReturn {
    @SerializedName("ServerMsg") public ServerMsg serverMsg;
    @SerializedName("LoginReturn") public LoginReturn loginReturn;

    public ResLoginReturn(ServerMsg serverMsg) {
        this.serverMsg = serverMsg;
    }

}