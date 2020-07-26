
package com.semicode.blooodbank.data.model.restPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestPassword {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private RestPasswordData restPasswordData;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RestPasswordData getRestPasswordData() {
        return restPasswordData;
    }

    public void setRestPasswordData(RestPasswordData restPasswordData) {
        this.restPasswordData = restPasswordData;
    }

}
