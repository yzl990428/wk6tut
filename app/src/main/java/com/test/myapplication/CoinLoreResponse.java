package com.test.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinLoreResponse {
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
